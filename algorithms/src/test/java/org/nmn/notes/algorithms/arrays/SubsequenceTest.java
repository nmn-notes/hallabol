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
}
