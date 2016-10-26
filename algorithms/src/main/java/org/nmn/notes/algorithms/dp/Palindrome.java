package org.nmn.notes.algorithms.dp;

import static org.nmn.notes.util.ArrayUtils.max;

/**
 * Find longest substring which is a Palindrome.
 * 
 * @see org.nmn.notes.algorithms.string.Palindrome for non-DP approach.
 * 
 * @author nmn-notes
 */
public class Palindrome {

	/**
	 * Use DP to get the longest palindrome in the given string.
	 * @param str String.
	 * @return length of longest substring which is a palindrome.
	 */
	public static int longestPalindrome(final String str) {
		int length = str.length();
		int [][] P = new int[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				//Every character is a palindrome.
				P[i][j] = (i == j) ? 1 : -1;
			}
		}

		return max(P);
	}
}
