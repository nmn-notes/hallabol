package org.nmn.notes.algorithms.arrays;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * Test client for {@link Subsequence}.
 * 
 * @author nmn-notes
 */
public class SubsequenceTest {

	/**
	 * Test maximum subsequence in the array.
	 */
	@Test
	public void testMaxSubsequence() {
		assertEquals(Subsequence.maxSubsequence(new int[] {10, 20, 30, 40, 50}), 150);
		assertEquals(Subsequence.maxSubsequence(new int[] {5, 6, -13, 8, 2, 11, -25, 20}), 21);
		assertEquals(Subsequence.maxSubsequence(new int[] {5, 6, -10, 8, 2, 11, -25, 20}), 22);
		assertEquals(Subsequence.maxSubsequence(new int[] {5, 6, -13, 8, 2, -2, 20}), 28);
		assertEquals(Subsequence.maxSubsequence(new int[] {5, -6, -13, -20}), 5);
	}

	/**
	 * Test minimum subsequence in the array.
	 */
	@Test
	public void testMinSubsequence() {
		assertEquals(Subsequence.minSubsequence(new int[] {10, 20, 30, 40, 50}), 10);
		assertEquals(Subsequence.minSubsequence(new int[] {60, 20, 10, 40, 50}), 10);
		assertEquals(Subsequence.minSubsequence(new int[] {5, 6, -13, 8, 2, 11, -25, 20}), -25);
		assertEquals(Subsequence.minSubsequence(new int[] {5, 6, -13, 3, -2, 5}), -13);
		assertEquals(Subsequence.minSubsequence(new int[] {5, 6, -13, 3, -6, 5}), -16);
		assertEquals(Subsequence.minSubsequence(new int[] {5, -6, -13, -20}), -39);
	}
}
