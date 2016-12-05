package org.nmn.notes.algorithms.number;

import static org.nmn.notes.algorithms.number.Multiplication.multiply;
import static org.testng.Assert.assertEquals;

import org.nmn.notes.algorithms.number.Multiplication;
import org.testng.annotations.Test;

/**
 * Test case for {@link Multiplication}
 * @author nmn-notes
 */
public class MulitplicationTest {

	/**
	 * Test multiplication method
	 */
	@Test
	public void testMultiply() {
		assertEquals(multiply(10, 20), 10 * 20);
		assertEquals(multiply(1, 10), 1 * 10);
		assertEquals(multiply(10, 1), 10 * 1);
	}
}
