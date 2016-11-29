package org.nmn.notes.algorithms.arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

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

	/**
	 * Test Kth smallest element in two sorted array.
	 */
	@Test
	public void testFindKthSmallestElement() {
		int [] arr1 = {2, 4, 5};
		int [] arr2 = {0, 1, 3, 6, 7, 8, 9};
		for (int i = 0; i < arr1.length + arr2.length; i++) {
			assertEquals(Merge.findKthSmallestElement(arr1, arr2, i), i);
		}
	}

	/**
	 * Test median of two sorted integer array.
	 */
	@Test
	public void testMedian() {
		int [] arr1 = {1};
		int [] arr2 = {1};
		// 1 1
		assertEquals(Merge.findMedian(arr1, arr2), 1.0);

		arr1 = new int[] {1, 3};
		arr2 = new int[] {2, 4};
		// 1 2 3 4
		assertEquals(Merge.findMedian(arr1, arr2), 2.5);

		arr1 = new int[] {1, 3, 5, 7, 9};
		arr2 = new int[] {2, 4};
		// 1 2 3 4 5 7 9
		assertEquals(Merge.findMedian(arr1, arr2), 4.0);

		arr1 = new int[] {};
		arr2 = new int[] {2, 4};
		assertEquals(Merge.findMedian(arr1, arr2), 3.0);

		arr1 = new int[] {};
		arr2 = new int[] {2, 4, 6};
		assertEquals(Merge.findMedian(arr1, arr2), 4.0);

		arr1 = new int[] {};
		arr2 = new int[] {};
		try {
			Merge.findMedian(arr1, arr2);
			fail("Must throw exception since both arrays are empty.");
		}
		catch (Exception e) {
			assertTrue(e instanceof IllegalArgumentException);
		}
	}
}
