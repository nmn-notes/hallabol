package org.nmn.notes.algorithms.arrays;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * Test client for {@link Fibonacci}
 * 
 * @author nmn-notes
 */
public class FibonacciTest {

	/**
	 * Test GetNthFibonacci.
	 */
	@Test
	public void testGetNthFibonacci() {
		assertEquals(Fibonacci.getNthFibonacci(0), 0);
		assertEquals(Fibonacci.getNthFibonacci(1), 1);
		assertEquals(Fibonacci.getNthFibonacci(2), 1);
		assertEquals(Fibonacci.getNthFibonacci(3), 2);
		assertEquals(Fibonacci.getNthFibonacci(4), 3);
		assertEquals(Fibonacci.getNthFibonacci(5), 5);
		assertEquals(Fibonacci.getNthFibonacci(6), 8);
		assertEquals(Fibonacci.getNthFibonacci(20), 6765);
		assertEquals(Fibonacci.getNthFibonacci(22), Fibonacci.getNthFibonacci(21) + Fibonacci.getNthFibonacci(20));
	}
}
