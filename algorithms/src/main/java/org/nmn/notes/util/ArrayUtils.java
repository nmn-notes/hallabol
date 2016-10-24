package org.nmn.notes.util;

/**
 * Utility methods for array
 * 
 * @author nmn-notes
 */
public final class ArrayUtils {

	/**
	 * Print array elements on console -> [1, 2, 3, 4, 5]
	 * @param arr integer array
	 */
	public static void printArray(int [] arr) {
		System.out.print("(");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length-1) {
				System.out.print(",");
			}
		}
		System.out.println(")");
	}

	/**
	 * Swap elements of integer array at index i and j.
	 * @param i first index to be swapped
	 * @param j second index to be swapped with
	 * @return swapped array. 
	 */
	public static int [] swap(int [] arr, int i, int j) {
		if (i == j) {
			return arr;
		}
		arr[i] = arr[i] + arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
		return arr;
	}

	/**
	 * Returns the maximum element in the array.
	 * 
	 * @param arr an integer array.
	 * @return maximum element in the array.
	 */
	public static int max(int [] arr) {
		int max = Integer.MIN_VALUE;
		for (int element : arr) {
			if (element > max) {
				max = element;
			}
		}
		return max;
	}

	/**
	 * Returns sum of the array.
	 * 
	 * @param arr an integer array.
	 * @return sum of the array.
	 */
	public static int sum(int [] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}
}
