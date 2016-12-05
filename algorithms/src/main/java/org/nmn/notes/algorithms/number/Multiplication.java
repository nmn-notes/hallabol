package org.nmn.notes.algorithms.number;

/**
 * A class used to multiply two integers
 * 
 * @author nmn-notes
 */
public class Multiplication {

	/**
	 * Multiply two positive integers and return the result.
	 * 
	 * @param x first integer
	 * @param y second integer
	 * @param result of the multiplication.
	 */
	public static int multiply(int x, int y) {
		//base condition
		if (y == 1) {
			return x;
		}
		else if (y == 0) {
			return 1;
		}

		if (y % 2 == 0) {
			//even case
			return 2 * multiply(x, y/2);
		}
		else {
			//odd case
			return (2 * multiply(x, y/2)) + x;
		}
	}
}
