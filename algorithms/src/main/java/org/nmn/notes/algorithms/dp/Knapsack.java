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
	 * 
	 * @param W Knapsack capacity.
	 * @param wt weight integer array.
	 * @param val value integer array.
	 * @param numOfWts total number of weights to be considered.
	 * @return maximum value of the knapsack.
	 */
	public static int knapsack(int W, int [] wt, int [] val, int numOfWts) {
		//Base case, when no more elements are left or knapsack does not have any capacity.
		if (numOfWts == 0 || W <= 0) {
			return 0;
		}

		/**
		 * If weight of the current item is more than the knapsack capacity W, this item
		 * cannot be included in the sack, hence moving forwared to next index. 
		 */
		if (wt[numOfWts - 1] > W) {
			return knapsack(W, wt, val, numOfWts - 1);
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
			(val[numOfWts - 1] + knapsack(W - wt[numOfWts - 1], wt, val, numOfWts - 1)),
			knapsack(W, wt, val, numOfWts - 1)
		);
	}
}
