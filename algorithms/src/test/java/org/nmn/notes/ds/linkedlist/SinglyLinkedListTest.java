package org.nmn.notes.ds.linkedlist;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

/**
 * Test class for {@link SinglyLinkedList}
 * 
 * @author nmn-notes
 */
public class SinglyLinkedListTest {

	/**
	 * Test add of linkedlist.
	 */
	@Test
	public void testAdd() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		assertEquals(sll.length(), 0);
		sll.add(1);
		assertEquals(sll.length(), 1);
		sll.add(2);
		assertEquals(sll.length(), 2);
	}
	/**
	 * Test number of times an element occurs in the list.
	 */
	@Test
	public void testCount() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(1);
		sll.add(2);
		sll.add(3);
		sll.add(4);
		assertEquals(sll.count(3), 1);
		sll.add(3);
		sll.add(3);
		sll.add(3);
		assertEquals(sll.count(3), 4);
	}

	/**
	 * Test getNth element of linkedlist.
	 */
	@Test
	public void testGetNth() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		assertEquals(sll.getNth(0), null);
		assertEquals(sll.getNth(1), null);
		sll.add(1);
		sll.add(2);
		sll.add(3);
		sll.add(4);
		assertEquals(sll.size(), 4);
		assertEquals(sll.size(), sll.length());
		assertEquals(sll.getNth(0), new Integer(1));
		assertEquals(sll.getNth(1), new Integer(2));
		assertEquals(sll.getNth(2), new Integer(3));
		assertEquals(sll.getNth(3), new Integer(4));
	}

	/**
	 * Test deleteList
	 */
	@Test
	public void testDeleteList() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(1);
		sll.add(2);
		sll.add(3);
		sll.add(4);
		assertEquals(sll.size(), 4);
		assertTrue(sll.deleteList());
		assertEquals(sll.size(), 0);
	}

	/**
	 * Test insertion of new node at specified index.
	 */
	@Test
	public void testInsertNth() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		assertFalse(sll.insertNth(1, 1));
		assertEquals(sll.size(), 0);
		assertTrue(sll.insertNth(0, 1));
		assertEquals(sll.size(), 1);
		assertEquals(sll.getNth(0), new Integer(1));
		assertTrue(sll.insertNth(0, 2));
		assertEquals(sll.size(), 2);
		assertEquals(sll.getNth(0), new Integer(2));
		assertEquals(sll.getNth(1), new Integer(1));
		assertTrue(sll.insertNth(2, 3));
		assertEquals(sll.size(), 3);
		assertEquals(sll.getNth(2), new Integer(3));
		assertFalse(sll.insertNth(6, 6));
		assertEquals(sll.size(), 3);
	}

	/**
	 * Test insertion of new node at the correct sorted position in the list.
	 */
	@Test
	public void testSortedInsert() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(2);
		sll.add(4);
		assertEquals(sll.sortedInsert(1), 0);
		assertEquals(sll.getNth(0), new Integer(1));
		assertEquals(sll.sortedInsert(5), 3);
		assertEquals(sll.getNth(3), new Integer(5));
		assertEquals(sll.sortedInsert(3), 2);
		assertEquals(sll.getNth(2), new Integer(3));
	}

	/**
	 * Test pop of linkedlist.
	 */
	@Test
	public void testPop() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		assertEquals(sll.pop(), null);
		sll.add(1);
		sll.add(2);
		assertEquals(sll.pop(), new Integer(1));
		assertEquals(sll.pop(), new Integer(2));
		assertEquals(sll.pop(), null);
	}
}
