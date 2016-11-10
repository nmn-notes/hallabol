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
		int [] C = {1, 2, 3};
		//{1, 1, 1}, {1, 2}, {3}
		assertEquals(CoinChange.count(C, C.length, 3), 3);

		//{1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}
		assertEquals(CoinChange.count(C, C.length, 4), 4);

		C = new int [] {2, 3, 5, 7, 8};

		//{2}
		assertEquals(CoinChange.count(C, C.length, 2), 1);

		//no solution since the lowest value coin is 2.
		assertEquals(CoinChange.count(C, C.length, 1), 0);

		//{2, 3}, {5}
		assertEquals(CoinChange.count(C, C.length, 5), 2);

		//{2,2,2,2,2}, {2,2,3,3}, {2,3,5}, {5,5}, {3,7}, {2,8}
		assertEquals(CoinChange.count(C, C.length, 10), 6);
	}

	/**
	 * Test coin count DP approach.
	 */
	@Test
	public void testCountDP_1() {
		int [] C = {1, 2, 3};
		//{1, 1, 1}, {1, 2}, {3}
		assertEquals(CoinChange.countDP(C, 3), 3);

		//{1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}
		assertEquals(CoinChange.countDP(C, 4), 4);

		C = new int [] {2, 3, 5, 7, 8};

		//{2}
		assertEquals(CoinChange.countDP(C, 2), 1);

		//no solution since the lowest value coin is 2.
		assertEquals(CoinChange.countDP(C, 1), 0);

		//{2, 3}, {5}
		assertEquals(CoinChange.countDP(C, 5), 2);

		//{2,2,2,2,2}, {2,2,3,3}, {2,3,5}, {5,5}, {3,7}, {2,8}
		assertEquals(CoinChange.countDP(C, 10), 6);
	}

	/**
	 * Test coin count DP approach.
	 */
	@Test
	public void testCountDP_2() {
		int [] C = {1, 2, 3};
		//{1, 1, 1}, {1, 2}, {3}
		assertEquals(CoinChange.count(C, 3), 3);

		//{1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}
		assertEquals(CoinChange.count(C, 4), 4);

		C = new int [] {2, 3, 5, 7, 8};

		//{2}
		assertEquals(CoinChange.count(C, 2), 1);

		//no solution since the lowest value coin is 2.
		assertEquals(CoinChange.count(C, 1), 0);

		//{2, 3}, {5}
		assertEquals(CoinChange.count(C, 5), 2);

		//{2,2,2,2,2}, {2,2,3,3}, {2,3,5}, {5,5}, {3,7}, {2,8}
		assertEquals(CoinChange.count(C, 10), 6);
	}

}
