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
		assertEquals(sll.size(), 0);
		sll.add(1);
		assertEquals(sll.size(), 1);
		sll.add(2);
		assertEquals(sll.size(), 2);
	}

	/**
	 * Test get of linkedlist.
	 */
	@Test
	public void testGet() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		assertEquals(sll.get(0), null);
		assertEquals(sll.get(1), null);
		sll.add(1);
		sll.add(2);
		sll.add(3);
		sll.add(4);
		assertEquals(sll.size(), 4);
		assertEquals(sll.get(0), new Integer(1));
		assertEquals(sll.get(1), new Integer(2));
		assertEquals(sll.get(2), new Integer(3));
		assertEquals(sll.get(3), new Integer(4));
	}
}
