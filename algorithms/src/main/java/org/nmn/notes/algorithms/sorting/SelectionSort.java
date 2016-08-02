package org.nmn.notes.algorithms.sorting;

/**
 * Selection sort example
 * 
 * @author Navin Naidu
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
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}
}
