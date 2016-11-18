package org.nmn.notes.util;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * Test class for {@link StringUtils}
 * 
 * @author nmn-notes
 */
public class StringUtilsTest {

	/**
	 * Test is blank or empty.
	 */
	@Test
	public void testIsBlackOrEmpty() {
		assertTrue(StringUtils.isBlankOrEmpty(null));
		assertTrue(StringUtils.isBlankOrEmpty(""));
		assertTrue(StringUtils.isBlankOrEmpty(" "));
		assertFalse(StringUtils.isBlankOrEmpty(" a"));
		assertFalse(StringUtils.isBlankOrEmpty("a "));
		assertFalse(StringUtils.isBlankOrEmpty("abc"));
	}

	/**
	 * Test occurrence of character in a given string.
	 */
	@Test
	public void testGetOccurrenceCount() {
		assertEquals(StringUtils.getOccurrenceCount("abbcd", 'b'), 2);
		assertEquals(StringUtils.getOccurrenceCount("abbcd", 'e'), 0);
		assertEquals(StringUtils.getOccurrenceCount("abbcd", 'd'), 1);
		assertEquals(StringUtils.getOccurrenceCount("abbcd", 'a'), 1);
	}
}
