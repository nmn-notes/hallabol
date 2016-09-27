package org.nmn.notes.ds.linkedlist;

import static org.testng.Assert.assertEquals;

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
