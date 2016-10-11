package org.nmn.notes.algorithms.string;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

/**
 * Test class for {@link Search}.
 * 
 * @author nmn-notes
 */
public class SearchTest {

	/**
	 * Test is second {@link String} is a prefix of first {@link String}.
	 */
	@Test
	public void testHasPrefix() {
		assertTrue(Search.hasPrefix("abcdef", "abc"));
		assertFalse(Search.hasPrefix("defabc", "abc"));
		assertTrue(Search.hasPrefix("abc", "abc"));
		assertFalse(Search.hasPrefix("abcdef", null));
		assertFalse(Search.hasPrefix(null, "abc"));
		assertFalse(Search.hasPrefix("abc", "abcdef"));
	}

	/**
	 * Test if second {@link String} contains in first {@link String}.
	 */
	@Test
	public void testContains() {
		assertTrue(Search.contains("abcdef", "ef"));
	}
}
