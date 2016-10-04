package org.nmn.notes.algorithms.string;

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
}
