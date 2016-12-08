package org.nmn.notes.algorithms.string;

/**
 * Given a string containing alphanumeric characters, calculate the sum of all numbers.
 * @author nmn-notes
 */
public class SumOfNumbers {

	/**
	 * Get sum of all numbers in the given string.
	 * 
	 * @param str {@link String}
	 * @return sum of all numbers.
	 */
	public static int getSum(final String str) {
		int sum = 0;
		StringBuilder number = new StringBuilder("0");
		for (char ch : str.toCharArray()) {
			if (Character.isDigit(ch)) {
				number.append(ch);
			}
			else {
				sum += Integer.valueOf(number.toString());
				number = new StringBuilder("0");
			}
		}
		sum += Integer.valueOf(number.toString());
		return sum;
	}
}
