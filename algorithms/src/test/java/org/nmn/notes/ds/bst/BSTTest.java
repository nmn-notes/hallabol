package org.nmn.notes.ds.bst;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

/**
 * Test class for {@link BST}
 * 
 * @author nmn-notes
 */
public class BSTTest {

	/**
	 * Test recursive insert in BST.
	 */
	@Test
	public void testInsertRecursively() {
		BST bst = new BST();
		assertEquals(bst.size(), 0);
		bst.insertRecursively(1);
		assertEquals(bst.size(), 1);
		bst.insertRecursively(2);
		assertEquals(bst.size(), 2);
	}

	/**
	 * Test if element is available in BST.
	 */
	@Test
	public void testHasElement() {
		BST bst = new BST();
		assertFalse(bst.hasElement(1));
		bst.insertRecursively(1);
		assertTrue(bst.hasElement(1));
		bst.insertRecursively(3);
		assertTrue(bst.hasElement(3));
		bst.insertRecursively(5);
		assertTrue(bst.hasElement(5));
	}

	/**
	 * Test iterative insert in BST.
	 */
	@Test
	public void testInsertIteratively() {
		BST bst = new BST();
		assertEquals(bst.size(), 0);
		bst.insertIteratively(1);
		assertEquals(bst.size(), 1);
		bst.insertIteratively(2);
		assertEquals(bst.size(), 2);
	}

	/**
	 * Test minimum and maximum value in BST.
	 */
	@Test
	public void testMinMaxValue() {
		BST bst = new BST();
		assertNull(bst.minValue());
		assertNull(bst.maxValue());
		bst.insertIteratively(13);
		bst.insertIteratively(30);
		bst.insertRecursively(10);
		bst.insertIteratively(1);
		bst.insertIteratively(2);
		assertEquals(bst.minValue(), new Integer(1));
		assertEquals(bst.maxValue(), new Integer(30));
	}

	/**
	 * Test hasPathSum in BST.
	 */
	@Test
	public void testHasPathSum() {
		BST bst = new BST();
		assertFalse(bst.hasPathSum(1));

		bst.insertIteratively(10);
		bst.insertIteratively(5);
		bst.insertIteratively(8);
		bst.insertIteratively(2);
		bst.insertIteratively(20);
		bst.insertIteratively(25);

		assertTrue(bst.hasPathSum(17));
		assertTrue(bst.hasPathSum(23));
		assertTrue(bst.hasPathSum(55));

		assertFalse(bst.hasPathSum(56));
		assertFalse(bst.hasPathSum(10));
	}
}
