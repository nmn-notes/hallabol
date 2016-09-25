package org.nmn.notes.algorithms.arrays;

/**
 * Fibonacci series
 * 
 * @author nmn-notes
 */
public class Fibonacci {

	/**
	 * Naive recursive algorithm to get Nth fibonacci number.
	 * if n == 0 return 0, if n == 1 return 1
	 * or recursively compute Fn-1 and Fn-2 and return addition.
	 * 
	 * This algorithm has exponential time complexity which is
	 * bad.
	 * 
	 * @param n index.
	 * @return fibonacci number at that index.
	 */
	public static int getNthFibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1) {
			return 1;
		}
		return getNthFibonacci(n-1) + getNthFibonacci(n-2);
	}
}
