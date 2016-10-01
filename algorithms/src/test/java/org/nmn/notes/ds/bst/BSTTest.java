package org.nmn.notes.ds.bst;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

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

	/**
	 * Test pre-order traversal of BST.
	 */
	@Test
	public void testPrintPreOrder() {
		BST bst = new BST();
		bst.insertIteratively(10);
		bst.insertIteratively(15);
		bst.insertIteratively(8);
		bst.insertIteratively(12);
		bst.insertIteratively(19);
		ArrayList<Integer> actual = bst.printPreOrder();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(10);
		expected.add(8);
		expected.add(15);
		expected.add(12);
		expected.add(19);
		assertEquals(actual, expected);
	}

	/**
	 * Test in-order traversal of BST.
	 */
	@Test
	public void testPrintInOrder() {
		BST bst = new BST();
		bst.insertIteratively(10);
		bst.insertIteratively(15);
		bst.insertIteratively(8);
		bst.insertIteratively(12);
		bst.insertIteratively(19);
		ArrayList<Integer> actual = bst.printInOrder();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(8);
		expected.add(10);
		expected.add(12);
		expected.add(15);
		expected.add(19);
		assertEquals(actual, expected);
	}

	/**
	 * Test post-order traversal of BST.
	 */
	@Test
	public void testPrintPostOrder() {
		BST bst = new BST();
		bst.insertIteratively(10);
		bst.insertIteratively(15);
		bst.insertIteratively(8);
		bst.insertIteratively(12);
		bst.insertIteratively(19);
		ArrayList<Integer> actual = bst.printPostOrder();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(8);
		expected.add(12);
		expected.add(19);
		expected.add(15);
		expected.add(10);
		assertEquals(actual, expected);
	}

	/**
	 * Test maximum depth of BST.
	 */
	@Test
	public void testMaxDepth() {
		BST bst = new BST();
		assertEquals(bst.maxDepth(), 0);
		bst.insertIteratively(10);
		assertEquals(bst.maxDepth(), 1);
		bst.insertIteratively(20);
		bst.insertIteratively(30);
		bst.insertIteratively(15);
		bst.insertIteratively(40);
		bst.insertIteratively(50);
		bst.insertIteratively(45);
		bst.insertIteratively(60);
		bst.insertIteratively(5);
		bst.insertIteratively(2);
		bst.insertIteratively(8);
		assertEquals(bst.maxDepth(), 6);
	}

	/**
	 * Test mirror of BST.
	 */
	@Test
	public void testMirror() {
		BST bst = new BST();
		bst.insertIteratively(10);
		bst.insertIteratively(15);
		bst.insertIteratively(8);
		bst.insertIteratively(12);
		bst.insertIteratively(19);
		ArrayList<Integer> actual = bst.printInOrder();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(8);
		expected.add(10);
		expected.add(12);
		expected.add(15);
		expected.add(19);
		assertEquals(actual, expected);
		bst.mirror();
		actual = bst.printInOrder();
		expected = new ArrayList<Integer>();
		expected.add(19);
		expected.add(15);
		expected.add(12);
		expected.add(10);
		expected.add(8);
		assertEquals(actual, expected);
	}

	/**
	 * Test double tree of BST.
	 */
	@Test
	public void testDoubleTree() {
		BST bst = new BST();
		bst.insertIteratively(10);
		bst.insertIteratively(15);
		bst.insertIteratively(8);
		bst.insertIteratively(12);
		bst.insertIteratively(19);
		ArrayList<Integer> actual = bst.printInOrder();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(8);
		expected.add(10);
		expected.add(12);
		expected.add(15);
		expected.add(19);
		assertEquals(actual, expected);
		bst.doubleTree();
		actual = bst.printInOrder();
		expected = new ArrayList<Integer>();
		expected.add(8);
		expected.add(8);
		expected.add(10);
		expected.add(10);
		expected.add(12);
		expected.add(12);
		expected.add(15);
		expected.add(15);
		expected.add(19);
		expected.add(19);
		assertEquals(actual, expected);
	}

	/**
	 * Test if two BST are structurally same.
	 */
	@Test
	public void testSameTree() {
		BST bst1 = new BST();
		BST bst2 = new BST();
		assertTrue(BST.sameTree(bst1, bst2));
		bst1.insertIteratively(10);
		assertFalse(BST.sameTree(bst1, bst2));
		bst2.insertIteratively(10);
		assertTrue(BST.sameTree(bst1, bst2));

		bst1.insertIteratively(5);
		bst1.insertIteratively(2);
		bst1.insertIteratively(8);
		bst1.insertIteratively(15);
		bst1.insertIteratively(25);
		bst1.insertIteratively(35);

		bst2.insertIteratively(5);
		bst2.insertIteratively(2);
		bst2.insertIteratively(8);
		bst2.insertIteratively(15);
		bst2.insertIteratively(25);
		bst2.insertIteratively(35);

		assertTrue(BST.sameTree(bst1, bst2));

		bst2.insertIteratively(36);
		assertFalse(BST.sameTree(bst1, bst2));
	}

	/**
	 * Test if a given tree is a valid BST.
	 */
	@Test
	public void testIsBST() {
		BST bst = new BST();
		assertTrue(bst.isBST());

		bst.insertIteratively(5);
		bst.insertIteratively(2);
		bst.insertIteratively(8);
		bst.insertIteratively(15);
		bst.insertIteratively(25);
		bst.insertIteratively(35);

		assertTrue(bst.isBST());

		//double tree should keep the BST intact.
		bst.doubleTree();
		assertTrue(bst.isBST());

		//mirror a BST will no longer keep it a valid BST.
		bst.mirror();
		assertFalse(bst.isBST());
	}

	/**
	 * Test if a given tree is a valid BST using modified logic where we keep track of the current min and max value
	 * while traversing down the tree evaluating a node only once.
	 */
	@Test
	public void testIsBSTModified() {
		BST bst = new BST();
		assertTrue(bst.isBST());

		bst.insertIteratively(5);
		bst.insertIteratively(2);
		bst.insertIteratively(8);
		bst.insertIteratively(15);
		bst.insertIteratively(25);
		bst.insertIteratively(35);

		assertTrue(bst.isBSTModified());

		//double tree should keep the BST intact.
		bst.doubleTree();
		assertTrue(bst.isBSTModified());

		//mirror a BST will no longer keep it a valid BST.
		bst.mirror();
		assertFalse(bst.isBSTModified());
	}
}
