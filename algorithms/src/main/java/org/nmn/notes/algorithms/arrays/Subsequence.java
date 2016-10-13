package org.nmn.notes.algorithms.arrays;

/**
 * Subsequence algorithms.
 * 
 * @author nmn-notes
 */
public class Subsequence {

	/**
	 * Find the maximum sum of subsequence in the given array.
	 * For ex: 1 2 -10 5 6 7 -20 6 7 has a maximum subsequence of 5+6+7=18
	 * @param arr array of integer.
	 * @return sum of maximum subsequence.
	 */
	public static int maxSubsequence(int [] arr) {
		int maxSum = arr[0];
		int sum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
			if (maxSum < sum) {
				maxSum = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}

	/**
	 * Find the minimum sum of subsequence in the given array.
	 * For ex: 1 2 -10 5 -20 6 7 has a minimum subsequence of -10 + 5 -20 = 25
	 * @param arr array of integer.
	 * @return sum of minimum subsequence.
	 */
	public static int minSubsequence(int [] arr) {
		int minSum = arr[0];
		int sum = arr[0];

		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
			if (arr[i] < sum) {
				sum = arr[i];
			}
			if (minSum > sum) {
				minSum = sum;
			}
			if (sum > 0) {
				sum = 0;
			}
		}
		return minSum;
	}
}
