package org.nmn.notes.algorithms.dp;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * Test class for {@link Knapsack}.
 * 
 * @author nmn-notes
 */
public class KnapsackTest {

	/**
	 * Test naive recursive knapsack algorithm.
	 */
	@Test
	public void testKnapsack() {
		int [] wt = {10, 5, 6, 1, 2};
		int [] val = {10, 20, 8, 50, 1};
		//wt-1 val-50
		assertEquals(Knapsack.knapsack(1, wt, val, wt.length), 50);

		//wt-1 val-50, wt-2 val-1
		assertEquals(Knapsack.knapsack(5, wt, val, wt.length), 51);

		//wt-1 val-50, wt-5 val-20
		assertEquals(Knapsack.knapsack(6, wt, val, wt.length), 70);
	}

	/**
	 * Test knapsack DP algorithm.
	 */
	@Test
	public void testKnapsackDP() {
		int [] wt = {10, 5, 6, 1, 2};
		int [] val = {10, 20, 8, 50, 1};
		//wt-1 val-50
		assertEquals(Knapsack.knapsackDP(1, wt, val), 50);

		//wt-1 val-50, wt-2 val-1
		assertEquals(Knapsack.knapsackDP(5, wt, val), 51);

		//wt-1 val-50, wt-5 val-20
		assertEquals(Knapsack.knapsackDP(6, wt, val), 70);
	}
}
