package org.nmn.notes.algorithms.arrays;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * Test client for {@link BinarySearch}.
 * 
 * @author nmn-notes
 */
public class BinarySearchTest {

	/**
	 * Test search iteratively.
	 */
	@Test
	public void testSearchIteratively() {
		int [] arr = {1, 3, 7, 8, 11, 14, 15};
		assertEquals(BinarySearch.searchIteratively(arr, 1), 0);
		assertEquals(BinarySearch.searchIteratively(arr, 11), 4);
		assertEquals(BinarySearch.searchIteratively(arr, 14), 5);
		assertEquals(BinarySearch.searchIteratively(arr, 15), 6);
		assertEquals(BinarySearch.searchIteratively(arr, 0), -1);
		assertEquals(BinarySearch.searchIteratively(arr, 17), -1);
		assertEquals(BinarySearch.searchIteratively(arr, 12), -1);
	}

	/**
	 * Test search recursively.
	 */
	@Test
	public void testSearchRecursively() {
		int [] arr = {1, 3, 7, 8, 11, 14, 15};
		assertEquals(BinarySearch.searchRecursively(arr, 1), 0);
		assertEquals(BinarySearch.searchRecursively(arr, 11), 4);
		assertEquals(BinarySearch.searchRecursively(arr, 14), 5);
		assertEquals(BinarySearch.searchRecursively(arr, 15), 6);
		assertEquals(BinarySearch.searchRecursively(arr, 0), -1);
		assertEquals(BinarySearch.searchRecursively(arr, 17), -1);
		assertEquals(BinarySearch.searchRecursively(arr, 12), -1);
	}
}
