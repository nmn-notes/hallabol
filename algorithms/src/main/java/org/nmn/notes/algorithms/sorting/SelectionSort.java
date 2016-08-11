package org.nmn.notes.algorithms.sorting;

import static org.nmn.notes.util.ArrayUtils.swap;

/**
 * Selection sort example
 * 
 * @author nmn-notes
 */
public class SelectionSort {

	/**
	 * Sort array of integers
	 * 
	 * This is a comparison sort algorithm with O(n^2) complexity
	 * 
	 * @param arr integer array
	 * @return sorted integer array
	 */
	public static int [] sort (int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int minIndex = i;
			//Search minimum element in the remaining array.
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < min) {
					minIndex = j;
				}
			}
			//Swap elements at i and minIndex
			swap(arr, i, minIndex);
		}
		return arr;
	}
}
