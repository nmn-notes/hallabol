package org.nmn.notes.algorithms.integer;

/**
 * Find greatest common divisor (GCD) of two numbers.
 * 
 * @author nmn-notes
 */
public class GCD {

	/**
	 * Euclidean recursive algorithm to find GCD of two numbers.
	 * 
	 * @param a first number.
	 * @param b second number.
	 * @return gcd of a and b.
	 */
	public static int gcdRecursive(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcdRecursive(b, a % b);
	}

	/**
	 * Euclidean algorithm to find GCD of two numbers.
	 * 
	 * @param a first number.
	 * @param b second number.
	 * @return gcd of a and b.
	 */
	public static int gcd(int a , int b) {
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
}
