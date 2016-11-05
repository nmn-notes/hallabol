package org.nmn.notes.algorithms.dp;

/**
 * Given a value N, and infinite supply of S = {S1, S2,...,Sm} valued coins,
 * how many ways can we make the change?
 * 
 * For example, for N = 3 and S = {1, 2, 3} there are three solutions:
 * {1, 1, 1}, {1, 2}, {3}. So output should be 3.
 * 
 * @author nmn-notes
 */
public class CoinChange {

	/**
	 * Find the number of ways we can make change for value n.
	 * 
	 * This method uses recursive approach to find the solution, for every coin there are two possible
	 * choices.
	 * a. Solution does NOT contain mth coin Sm.
	 * b. Solution does contains mth coin Sm.
	 * The time complexity of this algorithm is exponential O(2^n).
	 * 
	 * @param S array of valued coins.
	 * @param m number of coins available for the change.
	 * @param n value for which change is calculated.
	 * @return the count of number of ways change can be made.
	 */
	public static int count(int [] S, int m, int n) {
		//Value is 0, one solution found.
		if (n == 0) {
			return 1;
		}

		//Value is less than 0, no solution exists.
		if (n < 0) {
			return 0;
		}

		//No more coins left, no solution exists.
		if (m <= 0) {
			return 0;
		}

		/**
		 * Count is sum of:
		 * 1. current coin is NOT included, which does NOT change the value.
		 * 2. current coin is included, which reduces the value by current coin value.
		 */
		return count(S, m - 1, n) + count(S, m, n - S[m-1]);
	}
}
