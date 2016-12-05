package org.nmn.notes.algorithms.number;

/**
 * Prime number
 * 
 * @author nmn-notes
 */
public class Prime {

	/**
	 * Checks if a given number is a prime or not.
	 * 
	 * @param number to check.
	 * @return <code>true</code> if number is prime;
	 * 		   <code>false</code> otherwise.
	 */
	public static boolean isPrime(int number) {
		int den = number / 2;
		while (den > 1) {
			if (number % den == 0) {
				return false;
			}
			den--;
		}
		return true;
	}
}
