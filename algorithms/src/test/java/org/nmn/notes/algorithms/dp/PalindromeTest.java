package org.nmn.notes.algorithms.dp;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * Test class for {@link Palindrome}
 * 
 * @author nmn-notes
 */
public class PalindromeTest {

	/**
	 * Test longest palindrome in a given string.
	 */
	@Test
	public void testLongestPalindrome() {
		assertEquals(Palindrome.longestPalindrome("abc"), 1);
		assertEquals(Palindrome.longestPalindrome("abcbd"), 3);
	}
}
