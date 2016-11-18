package org.nmn.notes.util;

import static org.nmn.notes.util.Constants.EMPTY_STRING;

/**
 * Utility class for String.
 *
 * @author nmn-notes
 */
public final class StringUtils {

	/**
	 * Checks if given {@link String} is blank or empty.
	 *
	 * @param str the str
	 * @return <code>true</code>, if is blank or empty;
	 * 		   <code>false</code> otherwise.
	 */
	public static boolean isBlankOrEmpty(final String str) {
		return (null == str || EMPTY_STRING.equals(str.trim())) ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * Find the count of occurrence of a character in a given String.
	 * @param str {@link String}
	 * @param c character
	 * @return number of times character c occurred in the given string.
	 */
	public static int getOccurrenceCount(final String str, char c) {
		int count = 0;
		char [] charArr = str.toCharArray();
		for (char ch : charArr) {
			if (ch == c) {
				count++;
			}
		}
		return count;
	}
}
