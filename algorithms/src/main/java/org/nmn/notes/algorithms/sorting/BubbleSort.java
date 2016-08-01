package org.nmn.notes.algorithms.sorting;

import static org.nmn.notes.util.ArrayUtils.printArray;

/**
 * Bubble sort example
 * 
 * @author nmn-notes
 */
public class BubbleSort {

	/**
	 * Sort array of integers
	 * 
	 * This is a comparison sort algorithm with n^2 complexity
	 * 
	 * @param arr integer array
	 * @return sorted integer array
	 */
	public static int[] sort(int [] arr) {
		System.out.print("Array before sorting -> ");
		printArray(arr);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				System.out.println("Comparing " + arr[j] + " and " + arr[j+1]);
				if (arr[j] > arr[j+1]) {
					System.out.println(arr[j] + " greater than " + arr[j+1] + ", swap elements");
					//Swap elements
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;

					System.out.print("Array after swapping elements -> ");
					printArray(arr);
				}
			}

			System.out.println("**********************");
			System.out.print("Array after " + (i+1) + " pass -> ");
			printArray(arr);
			System.out.println("**********************");

		}
		return arr;
	}
}
