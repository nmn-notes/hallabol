package org.nmn.notes.util;

/**
 * Utility methods for array
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

}
