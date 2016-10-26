package org.nmn.notes.algorithms.string;

import static org.nmn.notes.util.StringUtils.isBlankOrEmpty;

/**
 * This class is used to check if a given string is or has a palindrome
 * 
 * Palidrome is a string which has same character sequence from start and end.
 * Ex. palindromes: abcdcba and abccba, 
 * whereas abcdba is not a palidrome since a matches a, b matches b but c does not match d.
 * 
 * @see org.nmn.notes.algorithms.dp.Palindrome for DP solution.
 * @author nmn-notes
 */
public class Palindrome {
	/**
	 * Check if given string is a palindrome or not.
	 * 
	 * @param str String
	 * @return <code>true</code> if palidrome;
	 * 		   <code>false</code> otherwise
	 */
	public static boolean isPalindrome(final String str) {
		if (isBlankOrEmpty(str)) {
			return false;
		}

		int start = 0;
		int end = str.length() - 1;
		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	/**
	 * Check if a given string from start index to end index is a palindrome or not.
	 * 
	 * @param str String
	 * @param start index of the string.
	 * @param end index of the string.
	 * @return <code>true</code> if palidrome;
	 * 		   <code>false</code> otherwise
	 */
	public static boolean isPalindrome(final String str, int start, int end) {
		if (start > end) {
			return false;
		}
		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	/**
	 * Returns length of the substring which is a palindrome.
	 * This brute force approach checks if any substring is a palindrome and returns its length if found one.
	 * 
	 * @param str String.
	 * @return length of the substring which is a palindrome; in worst case it will return 1 since a single character
	 * is also a palindrome.
	 */
	public static int hasPalindrome(final String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = str.length() - 1; j > i + 1; j--) {
				if (isPalindrome(str, i, j)) {
					return j - i + 1;
				}
			}
		}
		return 1;
	}

	/**
	 * Get the length of maximum palindrome available in the string.
	 * 
	 * @param str String.
	 * @return length of substring which is a palindrome.
	 */
	public static int maxPalindromeLengthBruteForce(final String str) {
		return maxPalindromeLengthBruteForce(str, 0, str.length() - 1);
	}

	/**
	 * Gets the length of maximum palindrome available in the string.
	 * The methods employs bruteforce method to find the maximum length.
	 * 
	 * It first checks if the given string is palindrome or not.
	 * If not, it makes recursive call to two substrings of s1
	 * 	1. s1.substring(0, s1.length-1)
	 * 	2. s2.substring(1, s1.length)
	 * and returns the maximum length of the two recursive call.
	 * 
	 * For ex: for string "abcb" since the string is not a palindrome,
	 * the two recursive calls are going to be:
	 * 1. string "abc"
	 * 2. string "bcb"
	 * 
	 * @param str String.
	 * @param start index of the substring.
	 * @param end index of the substring.
	 * @return length of the longest substring which is a palindrome.
	 */
	private static int maxPalindromeLengthBruteForce(final String str, int start, int end) {
		//Condition to break recursion
		if (start >= end) {
			return 1;
		}

		int i = start;
		int j = end;
		//Check if string is palindrome
		while (i <= j) {
			//If string is not palindrome, make two recursive calls on left and right substrings.
			if(str.charAt(i) != str.charAt(j)) {
				//recursive call to diverge the scope and return the largest palindrome of left and right substring.
				return Math.max(
					//check if left substring start, end - 1 is a substring.
					maxPalindromeLengthBruteForce(str, start, end - 1),
					//check if right substring start + 1, end is a substring.
					maxPalindromeLengthBruteForce(str, start + 1, end));
			}
			i++;
			j--;
		}
		return (end - start) + 1;
	}
}
