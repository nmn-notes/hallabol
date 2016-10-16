package org.nmn.notes.algorithms.dp;

/**
 * The knapsack problem or rucksack problem is a problem in combinatorial optimization: 
 * Given a set of items, each with a weight and a value, determine the number of each item 
 * to include in a collection so that the total weight is less than or equal to a given limit 
 * and the total value is as large as possible.
 * 
 * @author nmn-notes
 */
public class Knapsack {

	/**
	 * This approach finds the optimal substructure and solve overlapping subproblems using recursion.
	 * For every item if it can be included in the knapsack, there are two choices:
	 * 1. This item is included in the knapsack.
	 * 2. This item is NOT included in the knapsack.
	 * 
	 *  To decide whether this item should be included or not depends on the maximum value that can be obtained 
	 * This recursive algorithm has exponential time complexity O(2^n).
	 */
	public static int knapsack(int W, int [] wt, int [] val, int currIndex) {
		//Base case, when all elements are analyzed or no capacity left in knapsack.
		if (currIndex >= wt.length || W <= 0) {
			return 0;
		}

		/**
		 * If weight of the current item is more than the knapsack capacity W, this item
		 * cannot be included in the sack, hence moving forwared to next index. 
		 */
		if (wt[currIndex] > W) {
			return knapsack(W, wt, val, currIndex + 1);
		}

		/**
		 * The weight of the current item is less than the knapsack capacity W.
		 * At this point, we have two choices:
		 * a. Include this item, this will reduce knapsack capacity by weight of this item and increase
		 * the value by value of this item.
		 * b. Do NOT include this item, this will not change the knapsack capacity or value.
		 * 
		 * Finally, pick whichever choice returns higher value.
		 */
		return Math.max(
			(val[currIndex] + knapsack(W - wt[currIndex], wt, val, currIndex + 1)),
			knapsack(W, wt, val, currIndex + 1)
		);
	}
}
