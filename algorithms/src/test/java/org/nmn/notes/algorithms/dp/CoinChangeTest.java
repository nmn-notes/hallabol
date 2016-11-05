package org.nmn.notes.algorithms.dp;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * Test class for {@link CoinChange}.
 * 
 * @author nmn-notes
 */
public class CoinChangeTest {

	/**
	 * Test coin count.
	 */
	@Test
	public void testCount() {
		int [] S = {1, 2, 3};
		//{1, 1, 1}, {1, 2}, {3}
		assertEquals(CoinChange.count(S, S.length, 3), 3);

		//{1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}
		assertEquals(CoinChange.count(S, S.length, 4), 4);

		S = new int [] {2, 3, 5, 7, 8};

		//{2}
		assertEquals(CoinChange.count(S, S.length, 2), 1);

		//no solution since the lowest value coin is 2.
		assertEquals(CoinChange.count(S, S.length, 1), 0);

		//{2, 3}, {5}
		assertEquals(CoinChange.count(S, S.length, 5), 2);

		//{2,2,2,2,2}, {2,2,3,3}, {2,3,5}, {5,5}, {3,7}, {2,8}
		assertEquals(CoinChange.count(S, S.length, 10), 6);
	}
}
