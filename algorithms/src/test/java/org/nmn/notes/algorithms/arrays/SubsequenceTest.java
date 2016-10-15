package org.nmn.notes.algorithms.arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Test if given array has required sum using brute force.
	 */
	@Test
	public void testGetSumBruteForce() {
		assertTrue(Subsequence.getSumBruteForce(new int [] {15}, 15).isEmpty());
		assertTrue(Subsequence.getSumBruteForce(new int [] {30, 20, 10}, 15).isEmpty());

		List<Integer> expected = new ArrayList<>();
		expected.add(20);
		expected.add(10);
		assertEquals(Subsequence.getSumBruteForce(new int [] {30, 20, 10, 40, 60}, 30), expected);
		assertTrue(Subsequence.getSumBruteForce(new int [] {10, 20, 40}, 80).isEmpty());
	}

	/**
	 * Test if given array has required sum.
	 */
	@Test
	public void testGetSum() {
		assertTrue(Subsequence.getSum(new int [] {15}, 15).isEmpty());
		assertTrue(Subsequence.getSum(new int [] {30, 20, 10}, 15).isEmpty());

		List<Integer> expected = new ArrayList<>();
		expected.add(10);
		expected.add(20);
		assertEquals(Subsequence.getSum(new int [] {30, 20, 10, 40, 60}, 30), expected);
		assertTrue(Subsequence.getSum(new int [] {10, 20, 40}, 80).isEmpty());
	}
}
