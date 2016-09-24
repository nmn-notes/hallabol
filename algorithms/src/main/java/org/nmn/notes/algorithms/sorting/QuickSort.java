package org.nmn.notes.algorithms.sorting;

import static org.nmn.notes.util.ArrayUtils.swap;

/**
 * Quick sort.
 * 
 * @author nmn-notes
 */
public class QuickSort {

	/**
	 * Sort array of integers
	 * 
	 * This is a comparison sort algorithm with O(n^2) complexity
	 * 
	 * @param arr integer array.
	 * @return sorted integer array.
	 */
	public static int [] sort(int [] arr) {
		return quickSort(arr, 0, arr.length - 1);
	}

	/**
	 * Quicksort the array by partitioning the array at pivot and
	 * recursively calling quickSort again on the left and right side
	 * of the array.
	 * 
	 * @param arr integer array to be sorted.
	 * @param p start of the array.
	 * @param q end of the array.
	 * @return sorted array.
	 */
	private static int [] quickSort(int [] arr, int p, int q) {
		if (p < q) {
			int i = partition(arr, p, q);
			quickSort(arr, p, i-1);
			quickSort(arr, i+1, q);
		}
		return arr;
	}

	/**
	 * Partition the array around pivot element.
	 * Pivot is the element at index p.
	 * All elements smaller than pivot will be moved to left side of the pivot.
	 * All elements greater than the pivot will be moved to the right side of the pivot.
	 * 
	 * @param arr the array which is partitioned.
	 * @param p start of the array.
	 * @param q end of the array.
	 * @return the final index of the pivot after partition.
	 */
	private static int partition(int [] arr, int p, int q) {
		int pivot = arr[p];
		int i = p;
		for (int j = i+1; j <= q ; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i, p);
		return i;
	}
}
