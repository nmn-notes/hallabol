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
	 * @param C array of valued coins.
	 * @param m number of coins available for the change.
	 * @param n value for which change is calculated.
	 * @return the count of number of ways change can be made.
	 */
	public static int count(int [] C, int m, int n) {
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
		 * 1. Current coin is NOT included, which does NOT change the value.
		 * 2. Current coin is included, which reduces the value by current coin value.
		 */
		return count(C, m - 1, n) + count(C, m, n - C[m-1]);
	}

	/**
	 * Use DP approach to get the number of ways we can make change for value n.
	 * 
	 * This DP approach will use lookup table to first calculate and store number of ways change can be with with 1st coin,
	 * and update the number of ways change is made with introduction of a new coin.
	 * 
	 * The time complexity of this algorithm is O(n * number of coins) and space complexity of O(n).
	 * 
	 * @param C array of valued coins.
	 * @param n value for which change is calculated.
	 * @return the count of number of ways change can be made.
	 */
	public static int count(int [] C, int n) {
		//Lookup table, n+1 to store base case of value 0.
		int count [] = new int[n + 1];

		//Base case, when value is 0, 1 solution exists.
		count[0] = 1;

		//Introduce a new coin and re-calculate all values which are higher than current coin value.
		for (int i = 0; i < C.length; i++) {
			//Add number of ways change can be made with NEW coin. Only values greater than current coin will have another way to get change.
			for (int j = C[i]; j <= n; j++) {
				// New total number of ways change can be made for this value is sum of:
				count[j] = 
					// Existing number of ways change was made WITHOUT this coin.
					count[j] + 
					// Total number of ways change can be made WITH this coin which is equal to:
					// Total number of ways change can be made for a value less than coin value, since for every
					// such way if we add current coin, we will get current value.
					// For example if current considered coin is 8 from a coin set of {1, 2, 8} and current value is 10
					// Number of ways change be made for 2 is {1, 1} and {2}
					// Number of ways change can be made for 10 is by adding 10 to every way change was made for 2: {1, 1, 8}, {2, 8}
					count[j - C[i]];
			}
		}

		return count[n];
	}
}
