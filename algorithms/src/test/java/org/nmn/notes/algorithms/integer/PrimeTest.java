package org.nmn.notes.algorithms.integer;

import static org.testng.Assert.assertTrue;

import org.nmn.notes.algorithms.arrays.BinarySearch;
import org.nmn.notes.algorithms.integer.Prime;

import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

/**
 * Test class for {@link Prime}
 * 
 * @author nmn-notes
 */
public class PrimeTest {
	private static final int [] primeNumbers = 
		{1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 
		47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 
		107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 
		167, 173, 179, 181, 191, 193, 197, 199};

	/**
	 * Test if a given number is a prime or not.
	 */
	@Test
	public void testIsPrime() {
		for (int i = 1; i < 200; i++) {
			if (BinarySearch.searchIteratively(primeNumbers, i) != -1) {
				assertTrue(Prime.isPrime(i));
			}
			else {
				assertFalse(Prime.isPrime(i));
			}
		}
	}
}
