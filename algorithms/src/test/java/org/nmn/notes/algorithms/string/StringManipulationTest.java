package org.nmn.notes.algorithms.string;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

/**
 * Test class for {@link StringManipulation}
 * 
 * @author nmn-notes
 */
public class StringManipulationTest {

	/**
	 * Test if a given {@link String} has all unique characters.
	 */
	@Test
	public void testHasUniqueChars() {
		assertFalse(StringManipulation.hasUniqueChars("aa"));
		assertTrue(StringManipulation.hasUniqueChars("a"));
		assertTrue(StringManipulation.hasUniqueChars("abc"));
		assertTrue(StringManipulation.hasUniqueChars("abcdefgh"));
		assertFalse(StringManipulation.hasUniqueChars("abcadefgh"));
	}
}
