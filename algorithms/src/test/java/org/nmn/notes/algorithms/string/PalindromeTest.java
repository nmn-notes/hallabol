package org.nmn.notes.algorithms.string;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import org.nmn.notes.algorithms.string.Palindrome;
import org.testng.annotations.Test;

/**
 * Test class for {@link Palindrome}
 * @author nmn-notes
 */
public class PalindromeTest {

	/**
	 * Test isPalindrome
	 */
	@Test
	public void testIsPalindrome() {
		assertTrue(Palindrome.isPalindrome("abcdcba"));
		assertTrue(Palindrome.isPalindrome("a"));
		assertTrue(Palindrome.isPalindrome("abccba"));
		assertFalse(Palindrome.isPalindrome("ab"));
		assertFalse(Palindrome.isPalindrome("abcdba"));
	}

	/**
	 * Test isPalindrome substring.
	 */
	@Test
	public void testIsPalindromeSubstring() {
		assertTrue(Palindrome.isPalindrome("abcdcba", 0, "abcdcba".length() - 1));
		assertTrue(Palindrome.isPalindrome("a", 0, 0));
		assertTrue(Palindrome.isPalindrome("abccba", 0, "abccba".length() - 1));
		assertFalse(Palindrome.isPalindrome("ab", 0, 1));
		assertFalse(Palindrome.isPalindrome("abcdba", 0, "abcdba".length() - 1));
		assertFalse(Palindrome.isPalindrome("abcbef", 0, "abcbef".length() - 1));
		assertTrue(Palindrome.isPalindrome("abcbef", 1, 3));
		assertTrue(Palindrome.isPalindrome("defabccbaklh", 3, 8));
	}

	/**
	 * Test substring palindrome length.
	 */
	@Test
	public void testHasPalindromeLength() {
		assertEquals(Palindrome.hasPalindrome("abcdef"), 1);
		assertEquals(Palindrome.hasPalindrome("abccba"), 6);
		assertEquals(Palindrome.hasPalindrome("abadef"), 3);
		/**
		 * This is not the largest palidrome, largest palidrome is cdbdc of length 5, 
		 * but this method returns abc of length 3. 
		 */
		assertEquals(Palindrome.hasPalindrome("abacdbdc"), 3);
	}

	/**
	 * Test maximum length of a palindrome in a string by using brute force approach.
	 */
	@Test
	public void testMaxPalindromeLengthByBruteForce() {
		assertEquals(Palindrome.maxPalindromeLengthBruteForce("abc"), 1); // bb is a palindrome
		assertEquals(Palindrome.maxPalindromeLengthBruteForce("abba"), 4); // abba is a palindrome
		assertEquals(Palindrome.maxPalindromeLengthBruteForce("abdba"), 5); // abdba is a palindrome
		assertEquals(Palindrome.maxPalindromeLengthBruteForce("abb"), 2); // bb is a sub-string which is a palindrome
		assertEquals(
			Palindrome.maxPalindromeLengthBruteForce("kfabdbam"), 5); //abdba is a sub-string which is a palindrome
	}
}
