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
}
