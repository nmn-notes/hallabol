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
		 * cannot be included in the sack, hence moving forward to next index. 
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

	/**
	 * The above approach calculates same sub-problems over and over again which increases the complexity.
	 * This approach constructs the memoization table bottom UP and use the already computed result of a smaller
	 * sub-problem when considering a new item and increasing knapsack capacity.
	 * 
	 * To build memoization table bottom UP, first consider items.
	 * What will be the behavior when a new item is introduced, and after a new item is introduced
	 * re-calculate all values starting from if knapsack capacity is 0 till W.
	 * 
	 * @param W Knapsack capacity.
	 * @param wt weight integer array.
	 * @param val value integer array.
	 * @return maximum value of the knapsack.
	 */	
	public static int knapsackDP(int W, int [] wt, int [] val) {
		int [][] K = new int[wt.length + 1][W + 1];

		//Build memoization table bottom up.
		for (int i = 0; i <= wt.length; i++) {
			for (int w = 0; w <= W; w++) {
				//If number of items is 0 or knapsack capacity is 0.
				if (i == 0 || w == 0) {
					K[i][w] = 0;
				}
				//If weight of ith item is less than current knapsack capacity, if not, this item cannot be considered.
				else if (wt[i-1] <= w) {
					//Max of (value of this item + value of K without this item and knapsack capacity reduced by wt of
					//this item) or value of K without this item and same knapsack capacity.
					K[i][w] = Math.max(
						val[i-1] + K[i-1][w-wt[i-1]],
						K[i-1][w]);
				}
				else {
					K[i][w] = K[i-1][w];
				}
			}
		}
		//Finally return the value from table when all items and total knapsack capacity is considered.
		return K[wt.length][W];
	}
}
