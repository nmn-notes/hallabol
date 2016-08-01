package org.nmn.notes.algorithms.sorting;

/**
 * Insertion sort example
 * 
 * @author Navin Naidu
 */
public class InsertionSort {

	/**
	 * Sort array of integers
	 * 
	 * This is a comparison sort algorithm with O(n^2) complexity
	 * 
	 * @param arr integer array
	 * @return sorted integer array
	 */
	public static int [] sort(int [] arr) {
		for (int j = 1; j < arr.length; j++) {
			int key = arr[j];
			int i = j-1;
			while (i >= 0 && arr[i] > key) {
				arr[i+1] = arr[i];
				i--;
			}
			arr[i+1] = key;
		}
		return arr;
	}
}
