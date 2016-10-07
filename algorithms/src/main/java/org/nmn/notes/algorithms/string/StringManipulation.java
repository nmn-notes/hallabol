package org.nmn.notes.algorithms.string;

import org.nmn.notes.util.StringUtils;

/**
 * String manipulation algorithms.
 * 
 * @author nmn-notes
 */
public class StringManipulation {

	/**
	 * Checks if the given {@link String} has all unique characters.
	 * This is brute-force algorithm with O(n^2) time complexity.
	 * 
	 * @param str {@link String}.
	 * @return <code>true</code> if {@link String} has all unique characters;
	 * 		   <code>false</code> otherwise.
	 * @throws NullPointerException if str is null.
	 */
	public static boolean hasUniqueChars(final String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i+1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Checks if the given {@link String} has all unique characters.
	 * This is a linear algorithm with O(n) time complexity.
	 * The algorithm uses bitmap to store each character of {@link String}. Two bitmaps are used to store lower and
	 * higher ascii characters.
	 * 
	 * @param str {@link String} containing only 0-128 ascii characters.
	 * @return <code>true</code> if {@link String} has all unique characters;
	 * 		   <code>false</code> otherwise.
	 * @throws NullPointerException if str is null.
	 */	
	public static boolean hasUniqueCharsBitMap1(final String str) {
		final char[] charArr = str.toCharArray();
		long lowerRange = 0L;
		long higherRange = 0L;

		for (char c : charArr) {
			if (c < 64) {
				//duplicate character found
				if ((lowerRange & (1L << c)) > 0) {
					return false;
				}
				lowerRange = lowerRange | (1L << c);
			}
			else {
				//duplicate character found
				if ((higherRange & (1L << c)) > 0) {
					return false;
				}
				higherRange = higherRange | (1L << c);
			}
		}
		return true;
	}

	/**
	 * Checks if the given {@link String} has all unique characters.
	 * This is also a linear algorithm with O(n) time complexity.
	 * The algorithm uses bitmap to store each character of {@link String}. Two bitmaps are used to store lower and
	 * higher ascii characters and instead of using a shift operation uses {@link Math} power operation.
	 * 
	 * @param str {@link String} containing only 0-128 ascii characters.
	 * @return <code>true</code> if {@link String} has all unique characters;
	 * 		   <code>false</code> otherwise.
	 * @throws NullPointerException if str is null.
	 */	
	public static boolean hasUniqueCharsBitMap2(final String str) {
		final char[] charArr = str.toCharArray();
		long lowerRange = 0L;
		long higherRange = 0L;

		for (char c : charArr) {
			if (c < 64) {
				//duplicate character found
				if ((lowerRange & ((long)Math.pow(2, c))) > 0) {
					return false;
				}
				lowerRange = lowerRange | ((long)Math.pow(2, c));
			}
			else {
				//duplicate character found
				if ((higherRange & ((long)Math.pow(2, c % 64))) > 0) {
					return false;
				}
				higherRange = higherRange | ((long)Math.pow(2, c % 64));
			}
		}
		return true;
	}

	/**
	 * Returns the length of longest substring which has all unique characters.
	 * Only supports [a-zA-Z] {@link String}.
	 * 
	 * @str [a-zA-Z] {@link String}.
	 * @return length of the substring which has all unique characters; -1 if String is null or empty.
	 */
	public static int lengthOfLongestSubstringWithUniqueChars(final String str) {
		if (StringUtils.isBlankOrEmpty(str)) {
			return -1;
		}

		long bitMap = 0L;
		char[] charArr = str.toCharArray();
		int maxLength = 0;
		int length = 0;

		for (char c : charArr) {
			//duplicate character found, start a new substring.
			if ((bitMap & (1L << c)) > 0) {
				length = 0;
				bitMap = 0L;
			}
			bitMap = bitMap | (1L << c);
			length++;
			//new longest sub-string found.
			if (maxLength < length) {
				maxLength = length;
			}
		}

		return maxLength;
	}

	/**
	 * Reverse a given {@link String}.
	 * 
	 * @param str {@link String} to be reversed.
	 * @return reverse string.
	 */
	public static String reverseString(final String str) {
		if (str == null || StringUtils.isBlankOrEmpty(str)) {
			return str;
		}

		char [] charArr = str.toCharArray();
		int p = 0;
		int q = charArr.length - 1;

		while (p < q) {
			char temp = charArr[p];
			charArr[p] = charArr[q];
			charArr[q] = temp;
			p++;
			q--;
		}

		return String.valueOf(charArr);
	}

	/**
	 * Number of count of characters in a given {@link String}
	 * 
	 * @param str {@link String}.
	 * @param c character to be searched in the {@link String}.
	 * @return total number of search character found in the given {@link String}.
	 */
	public static int noOfChars(final String str, char c) {
		int count = 0;
		char[] arr = str.toCharArray();
		for (char ch : arr) {
			if (ch == c) {
				count++;
			}
		}
		return count;
	}
}
