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
		assertEquals(GCD.gcdRecursive(252, 105), 21);
		assertEquals(GCD.gcd(252, 105), 21);
	}
}
