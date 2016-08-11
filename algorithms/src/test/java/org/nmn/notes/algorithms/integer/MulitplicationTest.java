package org.nmn.notes.algorithms.integer;

import static org.testng.Assert.assertEquals;
import static org.nmn.notes.algorithms.integer.Multiplication.multiply;

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
