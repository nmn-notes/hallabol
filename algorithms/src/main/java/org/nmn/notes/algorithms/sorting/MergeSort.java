package org.nmn.notes.algorithms.sorting;

/**
 * Merge sort.
 * 
 * @author nmn-notes
 */
public class MergeSort {

	/**
	 * Sort an input integer array.
	 * Merge sort is a divide and conquer algorithm with nlogn complexity.
	 * 
	 * @param arr integer array.
	 * @return sorted integer array.
	 */
	public static int [] sort(int [] arr) {

		if (arr.length <= 1) {
			return arr;
		}

		int l1 = (arr.length % 2 == 0) ? arr.length / 2 : (arr.length / 2) + 1;
		int l2 = arr.length / 2;

		int [] arr1 = new int [l1];
		int [] arr2 = new int [l2];
		int j = 0;

		for (int i = 0; i < l1; i++) {
			arr1[i] = arr[j];
			j++;
		}

		for (int i = 0; i < l2; i++) {
			arr2[i] = arr[j];
			j++;
		}

		arr1 = sort(arr1);
		arr2 = sort(arr2);

		arr = merge(arr1, arr2);
		return arr;
	}

	/**
	 * Merge arr1 and arr2 to arr by comparing elements of each array and copying the smaller one.
	 * 
	 * @param arr1 first integer array.
	 * @param arr2 second integer array.
	 * @return merged array.
	 */
	private static int [] merge(int [] arr1, int [] arr2) {
		int i = 0;
		int j = 0;
		int k = 0;

		int [] arr = new int [arr1.length + arr2.length];

		// merge arr1 and arr2 to arr
		while (i < arr1.length && j < arr2.length) {
			// copy smaller element of arr1 and arr2 to arr
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

		return arr;
	}
}
