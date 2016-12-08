package org.nmn.notes.algorithms.string;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * Test class for {@link SumOfNumbers}
 * @author nmn-notes
 */
public class SumOfNumbersTest {

	/**
	 * Test sum of all numbers in a given string.
	 */
	@Test
	public void testGetSum() {
		assertEquals(SumOfNumbers.getSum("abc"), 0);
		assertEquals(SumOfNumbers.getSum("1a"), 1);
		assertEquals(SumOfNumbers.getSum("a1"), 1);
		assertEquals(SumOfNumbers.getSum("a1b"), 1);
		assertEquals(SumOfNumbers.getSum("a12b"), 12);
		assertEquals(SumOfNumbers.getSum("a12b3"), 15);
		assertEquals(SumOfNumbers.getSum("a12b30c20"), 62);
	}
}
