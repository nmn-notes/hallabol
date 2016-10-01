package org.nmn.notes.ds.bst;

import static org.testng.Assert.assertEquals;

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
	}
}
