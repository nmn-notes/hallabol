package org.nmn.notes.algorithms.string;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

/**
 * Test class for {@link Search}
 * @author nmn-notes
 */
public class SearchTest {

	/**
	 * Test hasPrefix
	 */
	@Test
	public void testHasPrefix() {
		assertTrue(Search.hasPrefix("abc", "abcdef"));
		assertFalse(Search.hasPrefix("abc", "defabc"));
		assertTrue(Search.hasPrefix("abc", "abc"));
		assertFalse(Search.hasPrefix(null, "abcdef"));
		assertFalse(Search.hasPrefix("abc", null));
		assertFalse(Search.hasPrefix("abcdef", "abc"));
		
	}
}
