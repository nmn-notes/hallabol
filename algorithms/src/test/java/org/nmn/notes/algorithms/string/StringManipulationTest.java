package org.nmn.notes.algorithms.string;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

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
	 * Test if a given {@link String} has all unique characters using a bit map.
	 */
	@Test
	public void testHasUniqueCharsBitMap2() {
		assertFalse(StringManipulation.hasUniqueCharsBitMap2("aa"));
		assertTrue(StringManipulation.hasUniqueCharsBitMap2("a"));
		assertTrue(StringManipulation.hasUniqueCharsBitMap2("abc"));
		assertTrue(StringManipulation.hasUniqueCharsBitMap2("abcdefgh"));
		assertFalse(StringManipulation.hasUniqueCharsBitMap2("abcadefgh"));
		assertTrue(StringManipulation.hasUniqueCharsBitMap2("z:"));
	}

	/**
	 * Test the length of longest substring with all unique characters.
	 */
	@Test
	public void testlenghtOfLongestSubstringWithUniqueChars() {
		assertEquals(StringManipulation.lengthOfLongestSubstringWithUniqueChars(null), -1);
		assertEquals(StringManipulation.lengthOfLongestSubstringWithUniqueChars(""), -1);
		assertEquals(StringManipulation.lengthOfLongestSubstringWithUniqueChars(" "), -1);
		assertEquals(StringManipulation.lengthOfLongestSubstringWithUniqueChars("a"), 1);
		assertEquals(StringManipulation.lengthOfLongestSubstringWithUniqueChars("aa"), 1);
		assertEquals(StringManipulation.lengthOfLongestSubstringWithUniqueChars("aab"), 2);
		assertEquals(StringManipulation.lengthOfLongestSubstringWithUniqueChars("aabb"), 2);
		assertEquals(StringManipulation.lengthOfLongestSubstringWithUniqueChars("aabcdeefg"), 5);
	}

	/**
	 * Test reversal of a {@link String}.
	 */
	@Test
	public void testReverseString() {
		assertNull(StringManipulation.reverseString(null));
		assertEquals(StringManipulation.reverseString(""), "");
		assertEquals(StringManipulation.reverseString("  "), "  ");
		assertEquals(StringManipulation.reverseString("a"), "a");
		assertEquals(StringManipulation.reverseString("ab"), "ba");
		assertEquals(StringManipulation.reverseString("abc"), "cba");
		assertEquals(StringManipulation.reverseString("abcd"), "dcba");
		assertEquals(StringManipulation.reverseString("abcdefghijk"), "kjihgfedcba");
		assertEquals(
			StringManipulation.reverseString("abasadasdasdddar"), 
			new StringBuilder("abasadasdasdddar").reverse().toString());
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

	/**
	 * Test if two {@link String}'s are anagrams are not.
	 */
	@Test
	public void testAreAnagrams() {
		assertFalse(StringManipulation.areAnagrams(null, null));
		assertFalse(StringManipulation.areAnagrams(null, "abc"));
		assertFalse(StringManipulation.areAnagrams("abc", null));
		assertTrue(StringManipulation.areAnagrams("abc", "bca"));
		assertTrue(StringManipulation.areAnagrams("hello", "olehl"));
		assertFalse(StringManipulation.areAnagrams("hello", "helloa"));
	}

	/**
	 * Test if two {@link String}'s are anagrams are not.
	 */
	@Test
	public void testAreAnagrams1() {
		assertFalse(StringManipulation.areAnagrams1(null, null));
		assertFalse(StringManipulation.areAnagrams1(null, "abc"));
		assertFalse(StringManipulation.areAnagrams1("abc", null));
		assertTrue(StringManipulation.areAnagrams1("abc", "bca"));
		assertTrue(StringManipulation.areAnagrams1("hello", "olehl"));
		assertFalse(StringManipulation.areAnagrams1("hello", "helloa"));
		assertFalse(StringManipulation.areAnagrams1("aabc", "aabca"));
	}

	/**
	 * Test if two {@link String}'s are anagrams are not.
	 */
	@Test
	public void testAreAnagrams2() {
		assertFalse(StringManipulation.areAnagrams2(null, null));
		assertFalse(StringManipulation.areAnagrams2(null, "abc"));
		assertFalse(StringManipulation.areAnagrams2("abc", null));
		assertTrue(StringManipulation.areAnagrams2("abc", "bca"));
		assertTrue(StringManipulation.areAnagrams2("hello", "olehl"));
		assertFalse(StringManipulation.areAnagrams2("hello", "helloa"));
		assertFalse(StringManipulation.areAnagrams1("aabc", "aabca"));
	}

	/**
	 * Check if second string is a rotated version of first string. To be a rotated version, the second string
	 * should follow the same character sequence of s1.
	 */
	@Test
	public void testIsRotated() {
		assertTrue(StringManipulation.isRotated("abc", "cab"));
		assertTrue(StringManipulation.isRotated("abc", "abc"));
		assertFalse(StringManipulation.isRotated("abc", "cba"));
		assertTrue(StringManipulation.isRotated("aabbcc", "bbccaa"));
	}

	/**
	 * Check if second string is a rotated version of first string using modified algorithm. 
	 * To be a rotated version, the second string should follow the same character sequence of s1.
	 */
	@Test
	public void testIsRotatedModified() {
		assertTrue(StringManipulation.isRotatedModified("abc", "cab"));
		assertTrue(StringManipulation.isRotatedModified("abc", "abc"));
		assertFalse(StringManipulation.isRotatedModified("abc", "cba"));
		assertTrue(StringManipulation.isRotatedModified("aabbcc", "bbccaa"));
	}
}
