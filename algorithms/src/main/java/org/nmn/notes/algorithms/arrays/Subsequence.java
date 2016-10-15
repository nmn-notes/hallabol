package org.nmn.notes.algorithms.arrays;

import java.util.ArrayList;
import java.util.List;

import org.nmn.notes.algorithms.sorting.QuickSort;

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

	/**
	 * Find if given array has required sum or not.
	 * Given an integer array, find two integers whose addition is equal to
	 * required sum, if no such integers exists, return empty list.
	 * 
	 * This is a brute-force algorithm and has O(n^2) time complexity.
	 * 
	 * @param arr integer array.
	 * @param sum required sum.
	 * @return {@link List} containing two {@link Integer}'s whose sum is 
	 * equal to the required sum; if no such integers exist, the list will be empty.
	 */
	public static  List<Integer> getSumBruteForce(int [] arr, int sum) {
		ArrayList<Integer> result = new ArrayList<>();
		if (arr.length < 2) {
			return result;
		}

		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					result.add(arr[i]);
					result.add(arr[j]);
					return result;
				}
			}
		}
		return result;
	}

	/**
	 * Find if given array has required sum or not.
	 * Given an integer array, find two integers whose addition is equal to
	 * required sum, if no such integers exists, return empty list.
	 * 
	 * The algorithm first sorts the given array and later finds the required sum; the complexity to search the sum
	 * is linear O(n) along with O(nlogn) time complexity to sort the array.
	 * 
	 * @param arr integer array.
	 * @param sum required sum.
	 * @return {@link List} containing two {@link Integer}'s whose sum is 
	 * equal to the required sum; if no such integers exist, the list will be empty.
	 */
	public static  List<Integer> getSum(int [] arr, int sum) {
		ArrayList<Integer> result = new ArrayList<>();
		if (arr.length < 2) {
			return result;
		}

		QuickSort.sort(arr);
		int begin = 0;
		int end = arr.length - 1;

		while (begin < end) {
			int currentSum = arr[begin] + arr[end];
			if (currentSum == sum) {
				result.add(arr[begin]);
				result.add(arr[end]);
				break;
			}
			else if (currentSum < sum) {
				begin++;
			}
			else {
				end--;
			}
		}
		return result;
	}

}
