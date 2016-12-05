package org.nmn.notes.algorithms.number;

/**
 * Find greatest common divisor (GCD) of two numbers.
 * 
 * @author nmn-notes
 */
public class GCD {

	/**
	 * Brute force approach to find gcd od two numbers.
	 * Start dividing number a and b with b till we find a number which divides both numbers.
	 */
	public static int gcdBruteForce(int a, int b) {
		for (int i = b; i > 1; i--) {
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}
		return 1;
	}

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
