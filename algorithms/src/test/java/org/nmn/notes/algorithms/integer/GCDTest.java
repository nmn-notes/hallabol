package org.nmn.notes.algorithms.integer;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * Test class for {@link GCD}
 * 
 * @author nmn-notes
 */
public class GCDTest {

	/**
	 * Test gcd of two numbers.
	 */
	@Test
	public void testGCD() {
		assertEquals(GCD.gcdBruteForce(100, 50), 50);
		assertEquals(GCD.gcdRecursive(100, 50), 50);
		assertEquals(GCD.gcd(100, 50), 50);

		assertEquals(GCD.gcdBruteForce(252, 105), 21);
		assertEquals(GCD.gcdRecursive(252, 105), 21);
		assertEquals(GCD.gcd(252, 105), 21);

		assertEquals(GCD.gcdBruteForce(9, 5), 1);
		assertEquals(GCD.gcdRecursive(9, 5), 1);
		assertEquals(GCD.gcd(9, 5), 1);

		assertEquals(GCD.gcdBruteForce(13, 11), 1);
		assertEquals(GCD.gcdRecursive(13, 11), 1);
		assertEquals(GCD.gcd(13, 11), 1);
	}
}
