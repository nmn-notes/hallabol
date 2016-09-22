package org.nmn.notes.algorithms.string;

/**
 * String search algorithms.
 * 
 * @author nmn-notes
 */
public class Search {

	/**
	 * Checks if the given str1 is prefix of str2
	 * 
	 * @param str1 prefix {@link String}
	 * @param str2 {@link String}
	 * @return <code>true</code> if str1 is prefix of str2;
	 * 		   <code>false</code> otherwise
	 */
	public static boolean hasPrefix(final String str1, final String str2){
		if (str1 == null || str2 == null || str1.length() > str2.length()) {
			return Boolean.FALSE;
		}
		return str1.hashCode() == str2.substring(0, str1.length()).hashCode() ? Boolean.TRUE : Boolean.FALSE;
	}
}
