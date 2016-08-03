package org.nmn.notes.util;

import static org.nmn.notes.util.Constants.EMPTY_STRING;

/**
 * Utility class for String
 */
public final class StringUtils {

	public static boolean isBlankOrEmpty(final String str) {
		return (null == str || EMPTY_STRING.equals(str.trim())) ? Boolean.TRUE : Boolean.FALSE;
	}
}
