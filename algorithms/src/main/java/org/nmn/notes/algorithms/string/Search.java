package org.nmn.notes.algorithms.string;

import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.FALSE;

/**
 * String search algorithms.
 * 
 * @author nmn-notes
 */
public class Search {

	/**
	 * Checks if the given str2 is prefix of str1.
	 * 
	 * @param str1 main {@link String}
	 * @param str2 prefix {@link String}
	 * @return <code>true</code> if str2 is prefix of str1;
	 * 		   <code>false</code> otherwise.
	 */
	public static boolean hasPrefix(final String str1, final String str2){
		if (str1 == null || str2 == null || str1.length() < str2.length()) {
			return FALSE;
		}
		return str1.substring(0, str2.length()).hashCode() == str2.hashCode() ? TRUE : FALSE;
	}

	/**
	 * Check if {@link String} s2 is a substring of {@link String} s1.
	 * 
	 * @param s1 main {@link String}.
	 * @param s2 substring {@link String}.
	 * @return <code>true</code> if s2 is a substring of s1;
	 * 		   <code>false</code> otherwise.
	 * @throws Exception if any.
	 */
	public static boolean contains(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() < s2.length()) {
			return FALSE;
		}

		final int s2HashCode = s2.hashCode();

		for (int i = 0; i < s1.length() - s2.length(); i++) {
			System.out.println("Evaulating string: " + s1.substring(i, i + s2.length()));
			if (s1.substring(i, i + s2.length()).hashCode() == s2HashCode) {
				return TRUE;
			}
		}
		return FALSE;
	}
}
