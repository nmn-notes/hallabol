package org.nmn.notes.algorithms.sorting;

import static org.testng.Assert.assertEquals;

import org.nmn.notes.algorithms.sorting.BubbleSort;
import org.testng.annotations.Test;

/**
 * Test client for array sorting algorithms
 * 
 * @author nmn-notes
 */
public class SortingTest {

	/**
	 * Test bubble sorting
	 */
	@Test
	public void testBubbleSort() {
		int [] arr = {9, 3, 7, 8, 1};
		int [] result = BubbleSort.sort(arr);
		int [] expected = {1, 3, 7, 8, 9};
		assertEquals(result, expected);
	}

	/**
	 * Test insertion sorting
	 */
	@Test
	public void testInsertionSort() {
		int [] arr = {9, 3, 7, 8, 1};
		int [] result = InsertionSort.sort(arr);
		int [] expected = {1, 3, 7, 8, 9};
		assertEquals(result, expected);
	}

	/**
	 * Test selection sorting
	 */
	@Test
	public void testSelectionSort() {
		int [] arr = {9, 3, 7, 8, 1};
		int [] result = SelectionSort.sort(arr);
		int [] expected = {1, 3, 7, 8, 9};
		assertEquals(result, expected);
	}

	/**
	 * Test merge sorting
	 */
	@Test
	public void testMergeSort() {
		int [] arr = {9, 3, 7, 8, 1};
		int [] result = MergeSort.sort(arr);
		int [] expected = {1, 3, 7, 8, 9};
		assertEquals(result, expected);
	}
}
