package org.nmn.notes.algorithms.arrays;

/**
 * Binary search.
 * Search for an element in a sorted integer array both iteratively/recursively in logN complexity.
 * 
 * @author nmn-notes
 */
public class BinarySearch {

	/**
	 * Does iterative binary search of the element in the passed integer array.
	 * Search complexity is O(log(N))
	 * @param arr integer array.
	 * @param element to be search in the integer array.
	 * @return index of the element in the integer array if found;
	 * else -1.
	 */
	public static int searchIteratively(int [] arr, int element) {
		int begin = 0;
		int end = arr.length - 1;
		while (begin <= end) {
			int index = (begin + end) / 2;
			if (arr[index] == element) {
				//element found
				return index;
			} 
			else if (arr[index] > element) {
				//element in left side of the array since it is smaller than the element at index.
				end = index - 1;
			}
			else {
				//element in the right side of the array since it is greater than the element at index.
				begin = index + 1;
			}
		}
		return -1;
	}

	/**
	 * Does recursive binary search of the element in the passed integer array.
	 * Search complexity is O(log(N))
	 * @param arr integer array.
	 * @param element to be search in the integer array.
	 * @return index of the element in the integer array if found;
	 * else -1.
	 */
	public static int searchRecursively(int [] arr, int element) {
		return searchRecursively(arr, element, 0, arr.length - 1);
	}

	private static int searchRecursively(int [] arr, int element, int begin, int end) {
		if (begin > end) {
			return -1;
		}
		int index = (begin + end) / 2;

		if (arr[index] == element) {
			//element found
			return index;
		}
		else if (arr[index] > element) {
			//search on the left side of the array since the element is smaller than the element at index.
			return searchRecursively(arr, element, begin, index - 1);
		}
		else {
			//search on the right side of the array since the element is smaller than the element at index.
			return searchRecursively(arr, element, index + 1, end);
		}
	}
}
