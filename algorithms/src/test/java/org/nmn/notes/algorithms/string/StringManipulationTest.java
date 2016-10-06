package org.nmn.notes.algorithms.string;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

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

	/**
	 * Test if a given {@link String} has all unique characters using a bit map.
	 */
	@Test
	public void testHasUniqueCharsBitMap1() {
		assertFalse(StringManipulation.hasUniqueCharsBitMap1("aa"));
		assertTrue(StringManipulation.hasUniqueCharsBitMap1("a"));
		assertTrue(StringManipulation.hasUniqueCharsBitMap1("abc"));
		assertTrue(StringManipulation.hasUniqueCharsBitMap1("abcdefgh"));
		assertFalse(StringManipulation.hasUniqueCharsBitMap1("abcadefgh"));
		assertTrue(StringManipulation.hasUniqueCharsBitMap1("z:"));
	}

	/**
	 * Test number of characters in a given {@link String}.
	 */
	@Test
	public void testNoOfChars() {
		assertEquals(StringManipulation.noOfChars("abc", 'a'), 1);
		assertEquals(StringManipulation.noOfChars("abcaa", 'a'), 3);
		assertEquals(StringManipulation.noOfChars("abcaadbad", 'a'), 4);
		assertEquals(StringManipulation.noOfChars("abcaadbad", 'e'), 0);
		assertEquals(StringManipulation.noOfChars("abcaadbad", 'b'), 2);
	}
}
