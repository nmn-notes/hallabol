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
	 * This method uses DP approach to get the length of longest substring which is a palindrome.
	 * 
	 * We first start analyzing all smaller substrings of length 2, later while analyzing substrings of longer
	 * length (3, 4...n), we will use the result of already computed smaller substrings.
	 * 
	 * A 2 dimensional lookup table till be used to store the result, where index i,j will store the result
	 * of substring (i,j).
	 * 
	 * A substring at index(i, j) will be palindrome, if char at i and j matches and the substring (i+1, j-1)
	 * is also a palindrome.
	 * 
	 * @param str String.
	 * @return length of longest substring which is a palindrome.
	 * @throws Exception if any.
	 */
	public static int longestPalindrome(final String str) {
		int length = str.length();
		int [][] L = new int[length][length];

		for (int i = 0; i < length; i ++) {
			for (int j = 0; j < length; j++) {
				//Every character is a palindrome of length 1.
				L[i][j] = (i == j) ? 1 : -1;
			}
		}

		int subStrLength = 2;
		//Starting analyzing substrings from length 2 to length of the of the entire string.
		while (subStrLength <= length) {
			//Analyze every substring of length of length subStrLength.
			for (int i = 0; i < length - subStrLength + 1; i++) {
				int j = i + subStrLength - 1; //end index of substring.

				//For a substring to be a palindrome, below conditions should match.
				//a. Either substring is of length 2 or inner substring is also a palindrome.
				if ((subStrLength == 2 || L[i+1][j-1] != -1) && 
						//b. character at start and end index of the current substring should match.
						str.charAt(i) == str.charAt(j)) {
					//new palindrome length = length of inner palindrome + 2 characters at i & j. 
					L[i][j] = L[i+1][j-1] + 2;
				}
				else {
					L[i][j] = -1;
				}
			}
			//increment substring length.
			subStrLength++;
		}

		//return the highest palindrome found.
		return max(L);
	}
}
