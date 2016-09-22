package org.nmn.notes.valve;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.ServletException;

import org.apache.catalina.Valve;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import com.google.gson.Gson;

/**
 * <p>Implementation of {@link Valve} interface to intercept every Server request and collect
 * required metrics.
 * 
 * Metrics will capture total number of API requests, API-1 request and total error counts and
 * POST data to telemetry server at configured duration.
 * 
 * To enable Tomcat metrics valve set tomcat.metrics.valve.enabled System Property to true, default value is set to false.
 * POST interval can be configured using tomcat.metrics.valve.posting.interval.in.seconds, default value is set to 60 seconds.
 * Telemetry server URL is configured using tomcat.metrics.valve.telemetry.server.url System Property
 * Server namespace is configured using tomcat.metrics.valve.namespace System Property
 */
public final class TomcatMetricsValve extends ValveBase {

	private static final Log LOG = LogFactory.getLog(TomcatMetricsValve.class);

	private static final String TOMCAT_METRICS_VALVE_ENABLED_KEY = "tomcat.metrics.valve.enabled";
	private static final String POSTING_INTERVAL_IN_SEC_KEY = "tomcat.metrics.valve.posting.interval.in.seconds";
	private static final String TOMCAT_METRICS_VALVE_NAMESPACE = "tomcat.metrics.valve.namespace";
	private static final String TELEMETRY_SERVER_URL_KEY = "tomcat.metrics.valve.telemetry.server.url";

	private static AtomicInteger totalHits;
	private static AtomicInteger errorCount;
	private static AtomicInteger apiCount;

	private static final String API_REGEX = "/apis/api-1.*";
	private static AtomicReference<ArrayList<Long>> apiResponseTimes = new AtomicReference<ArrayList<Long>>();

	private static Set<Integer> ERROR_CODES = new HashSet<Integer>();

	private static final Boolean METRICS_ENABLED;
	private static final Long POSTING_INTERVAL_IN_SECONDS;
	private static final String NAMESPACE;
	private static final String TELEMETRY_SERVER_URL;

	static {
		LOG.info("Tomcat metrics log invoked");
		METRICS_ENABLED = Boolean.valueOf(System.getProperty(TOMCAT_METRICS_VALVE_ENABLED_KEY, Boolean.FALSE.toString()));
		POSTING_INTERVAL_IN_SECONDS = Long.valueOf(System.getProperty(POSTING_INTERVAL_IN_SEC_KEY, "60"));
		NAMESPACE = System.getProperty(TOMCAT_METRICS_VALVE_NAMESPACE, "local");
		TELEMETRY_SERVER_URL = System.getProperty(TELEMETRY_SERVER_URL_KEY, "localhost:9200/telemetry/metrics");

		if (METRICS_ENABLED) {
			totalHits = new AtomicInteger(0);
			errorCount = new AtomicInteger(0);
			apiCount = new AtomicInteger(0);
			ERROR_CODES.add(500);

			final ScheduledExecutorService executorService = 
				Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
				private volatile int threadCount = 1;
				@Override
				public Thread newThread(Runnable r) {
					Thread t = new Thread(
						new ThreadGroup("tomcat-metrics-valve-pool"), r, "timer-thread" + threadCount++);
					t.setDaemon(true);
					return t;
				}
			});

			PostingThread postThread = new PostingThread();
			executorService.scheduleAtFixedRate(
				postThread, POSTING_INTERVAL_IN_SECONDS, POSTING_INTERVAL_IN_SECONDS, TimeUnit.SECONDS);
			LOG.info("TomcatMetricsValve enabled, will post every: " + POSTING_INTERVAL_IN_SECONDS + " with namespace: " + NAMESPACE + " seconds to: " + TELEMETRY_SERVER_URL);
		}
		else {
			LOG.info("TomcatMetricsValve is not enabled");
		}
	}

	@Override
	public void invoke(Request req, Response res) throws IOException, ServletException {
		long then = System.currentTimeMillis();

		if (!METRICS_ENABLED) {
			getNext().invoke(req, res);
			return;
		}

		totalHits.getAndIncrement();

		final String requestURI = req.getRequestURI();
		if (requestURI != null && requestURI.matches(API_REGEX)) {
			apiCount.getAndIncrement();
		}

		getNext().invoke(req, res);

		if (ERROR_CODES.contains(res.getStatus())) {
			errorCount.getAndIncrement();
		}

		long now = System.currentTimeMillis();
		apiResponseTimes.get().add(now - then);
	}

	/**
	 * Worker thread which will POST telemetry metrics to TELEMETRY server at regular duration.
	 */
	private static final class PostingThread implements Runnable {

		private static final String POST = "POST";
		private static final String CONTENT_TYPE_HEADER = "Content-Type";
		private static final String CONTENT_TYPE_HEADER_VALUE = "application/json";

		public void run() {
			try {
				PostRequest request = new PostRequest();
				request.server = NAMESPACE;
				request.totalHits = totalHits.getAndSet(0);
				request.errorCounts = errorCount.getAndSet(0);
				ArrayList<Long> apiResponseTimesList = apiResponseTimes.getAndSet(new ArrayList<Long>());
				request.meanTime = getMean(apiResponseTimesList);
				request.timeStamp = System.currentTimeMillis();
				Gson gson = new Gson();
				final String requestJSON = gson.toJson(request);
				LOG.info("Sending POST metrics request - server: " + request.server + ", totalHits: " + request.totalHits + 
					", errorCounts: " + request.errorCounts + ", meanTime: " + request.meanTime + ", timeStamp: " + request.timeStamp);
				sendPOST(requestJSON);
			}
			catch (Exception ex) {
				LOG.error("Error while posting telemetry metrics data", ex);
			}
		}

		/**
		 * Send POST request to TELEMETRY_SERVER_URL
		 * @param jsonRequest JSON request
		 * @return response of the POST call
		 */
		private static String sendPOST(final String jsonRequest) throws IOException {
			URL url = new URL(TELEMETRY_SERVER_URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(POST);
			connection.setRequestProperty(CONTENT_TYPE_HEADER, CONTENT_TYPE_HEADER_VALUE);
			connection.setDoOutput(Boolean.TRUE);

			DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
			writer.writeBytes(jsonRequest);
			writer.flush();
			writer.close();

			final int responseCode = connection.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			LOG.info("Posted telemetry metrics request with response code :" + responseCode);
			return response.toString();
		}

	}

	/**
	 * Telemetry POST request POJO capturing server metrics
	 */
	private static final class PostRequest {
		String server;
		long totalHits;
		long errorCounts;
		long timeStamp;
		double meanTime;
	}

	/**
	 * Gets mean of the array
	 * @param times {@link ArrayList} of response times
	 * @return mean time of the array
	 */
	private static double getMean(ArrayList<Long> times) {
		int length = times.size();
		if (length < 2) {
			return (length == 1) ? times.get(0) : 0;
		}

		double median;
		Collections.sort(times);

		if (length % 2 == 0) {
			median = (times.get(length/2) + times.get(length/2 - 1)) / 2;
		}
		else {
			median = times.get(length/2);
		}
		return median;
	}
}
