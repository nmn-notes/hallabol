package org.nmn.notes.algorithms.arrays;

/**
 * Find sum of middle elements after merging two sorted arrays.
 * 
 * @author nmn-notes
 */
public class Merge {

	/**
	 * Given two sorted integer arrays, return sum of middle elements
	 * of array obtained after merging the given array.
	 * 
	 * @param arr1 first integer array.
	 * @param arr2 second integer array.
	 * @return sum of middle elements after merging arr1 and arr2.
	 */
	public static int sumOfMiddleElementsBF(int [] arr1, int [] arr2) {
		int i = 0;
		int j = 0;
		int k = 0;
		int [] arr = new int[arr1.length + arr2.length];

		// merge arr1 and arr2 to arr
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				arr[k] = arr1[i];
				i++;
			}
			else {
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}

		// copy remaining elements of arr1
		while (i < arr1.length) {
			arr[k] = arr1[i];
			i++;
			k++;
		}

		// copy remaining elements of arr2
		while (j < arr2.length) {
			arr[k] = arr2[j];
			j++;
			k++;
		}

		int mid = arr.length / 2;
		return arr[mid - 1] + arr[mid];
	}

	/**
	 * Given two sorted integer arrays, return sum of middle elements
	 * of array obtained after merging the given array.
	 * 
	 * Complexity of algorithm is O(n + m)
	 * 
	 * @param arr1 first integer array.
	 * @param arr2 second integer array.
	 * @return sum of middle elements after merging arr1 and arr2.
	 */
	public static int sumOfMiddleElements(int [] arr1, int [] arr2) {
		int indexOfMiddleElement = (arr1.length + arr2.length) / 2;
		int i = 0;
		int j = 0;
		int k = 0;

		int firstElement = 0;
		int secondElement = 0;

		while (k <= indexOfMiddleElement && i < arr1.length && j < arr2.length) {
			firstElement = secondElement;
			if (arr1[i] < arr2[j]) {
				secondElement = arr1[i];
				i++;
			}
			else {
				secondElement = arr2[j];
				j++;
			}
			k++;
		}

		while(k <= indexOfMiddleElement && i < arr1.length) {
			firstElement = secondElement;
			secondElement = arr1[i];
			i++;
			k++;
		}

		while(k <= indexOfMiddleElement && j < arr2.length) {
			firstElement = secondElement;
			secondElement = arr2[j];
			j++;
			k++;
		}

		return firstElement + secondElement;
	}

	/**
	 * Find Kth smallest element after merging two sorted arrays.
	 * 
	 * @param arr1 first sorted array.
	 * @param arr2 second sorted array.
	 * @param k index of the smallest element to be found in the merged array.
	 * @return Kth smallest element.
	 * @throws IllegalArgumentException if k is out of range.
	 */
	public static int findKthSmallestElement(int [] arr1, int [] arr2, int k) {
		if (k < 0 && k >= (arr1.length + arr2.length)) {
			throw new IllegalArgumentException("Index out of bound");
		}

		int i = 0;
		int j = 0;
		int m = 0;
		int element = -1;

		while (m <= k && i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				element = arr1[i];
				i++;
			}
			else {
				element = arr2[j];
				j++;
			}
			m++;
		}

		int remainingElements = k - m;

		if (m <= k && i < arr1.length) {
			element = arr1[i + remainingElements];
		}
		else if (m <= k && j < arr2.length) {
			element = arr2[j + remainingElements];
		}

		return element;
	}

	/**
	 * Find median of two sorted integer array.
	 * If merged array length is even, median will mean of middle two elements,
	 * else it will be middle element of the merged array.
	 * 
	 * @param arr1 first sorted integer array.
	 * @param arr2 second sorted integer array.
	 * @return median of the merged array.
	 * @throws Exception if any.
	 */
	public static double findMedian(int [] arr1, int [] arr2) {
		if (arr1.length == 0 && arr2.length == 0) {
			throw new IllegalArgumentException("Both arrays cannot be empty");
		}

		int length = arr1.length + arr2.length;
		double median;

		if (length % 2 == 0) {
			double sumOfMiddleElements = sumOfMiddleElements(arr1, arr2);
			median = sumOfMiddleElements / 2;
		}
		else {
			median = findKthSmallestElement(arr1, arr2, length / 2);
		}
		return median;
	}
}
