package org.nmn.notes.algorithms.arrays;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * Test class for {@link Merge}
 * 
 * @author nmn-notes.
 */
public class MergeTest {

	/**
	 * Test sum of middle elements of two sorted integer array.
	 */
	@Test
	public void testSumOfMiddleElementsBF() {
		int [] arr1 = {1, 3};
		int [] arr2 = {2, 4};
		assertEquals(Merge.sumOfMiddleElementsBF(arr1, arr2), 5);

		arr1 = new int[] {2, 3, 4, 5};
		arr2 = new int[] {6, 7, 8, 9};
		assertEquals(Merge.sumOfMiddleElementsBF(arr1, arr2), 11);
		assertEquals(Merge.sumOfMiddleElementsBF(arr2, arr1), 11);

		arr1 = new int[] {1};
		arr2 = new int[] {1};
		assertEquals(Merge.sumOfMiddleElementsBF(arr1, arr2), 2);
	}

	/**
	 * Test sum of middle elements of two sorted integer array.
	 */
	@Test
	public void testSumOfMiddleElements() {
		int [] arr1 = {1, 3};
		int [] arr2 = {2, 4};
		assertEquals(Merge.sumOfMiddleElements(arr1, arr2), 5);

		arr1 = new int[] {2, 3, 4, 5};
		arr2 = new int[] {6, 7, 8, 9};
		assertEquals(Merge.sumOfMiddleElements(arr1, arr2), 11);
		assertEquals(Merge.sumOfMiddleElements(arr2, arr1), 11);

		arr1 = new int[] {1};
		arr2 = new int[] {1};
		assertEquals(Merge.sumOfMiddleElements(arr1, arr2), 2);
	}
}
