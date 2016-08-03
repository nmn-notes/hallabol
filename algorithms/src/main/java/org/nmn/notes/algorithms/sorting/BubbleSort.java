package org.nmn.notes.algorithms.sorting;

import static org.nmn.notes.util.ArrayUtils.printArray;
import static org.nmn.notes.util.ArrayUtils.swap;

/**
 * Bubble sort example
 * 
 * @author nmn-notes
 */
public class BubbleSort {

	/**
	 * Sort array of integers
	 * 
	 * This is a comparison sort algorithm with O(n^2) complexity
	 * 
	 * @param arr integer array
	 * @return sorted integer array
	 */
	public static int[] sort(int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j] > arr[j+1]) {
					//Swap elements
					swap(arr, j, j+1);
				}
			}
		}
		return arr;
	}
}
