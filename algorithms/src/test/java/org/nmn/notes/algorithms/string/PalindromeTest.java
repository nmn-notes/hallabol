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
