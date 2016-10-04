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
}
