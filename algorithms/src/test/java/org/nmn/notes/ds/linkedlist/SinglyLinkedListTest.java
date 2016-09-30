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
	 * Test sorting of the list.
	 */
	@Test
	public void testInsertSort() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(3);
		sll.add(2);
		sll.add(1);
		assertEquals(sll.getNth(0), new Integer(3));
		assertEquals(sll.getNth(1), new Integer(2));
		assertEquals(sll.getNth(2), new Integer(1));
		assertEquals(sll.size(), 3);
		sll.insertSort();
		assertEquals(sll.getNth(0), new Integer(1));
		assertEquals(sll.getNth(1), new Integer(2));
		assertEquals(sll.getNth(2), new Integer(3));
		assertEquals(sll.size(), 3);
	}

	/**
	 * Test frontback split of the list.
	 */
	@Test
	public void testFrontBackSplit() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		SinglyLinkedList<Integer> newList = sll.frontBackSplit();
		assertEquals(newList.size(), 0);
		sll.add(1);
		newList = sll.frontBackSplit();
		assertEquals(sll.size(), 1);
		assertEquals(newList.size(), 0);
		sll.add(2);
		newList = sll.frontBackSplit();
		assertEquals(sll.size(), 1);
		assertEquals(newList.size(), 1);
		assertEquals(sll.getNth(0), new Integer(1));
		assertEquals(newList.getNth(0), new Integer(2));

		sll.add(2);
		sll.add(3);
		newList = sll.frontBackSplit();
		assertEquals(sll.size(), 2);
		assertEquals(newList.size(), 1);
		assertEquals(sll.getNth(0), new Integer(1));
		assertEquals(sll.getNth(1), new Integer(2));
		assertEquals(newList.getNth(0), new Integer(3));

		sll.add(3);
		sll.add(4);
		newList = sll.frontBackSplit();
		assertEquals(sll.size(), 2);
		assertEquals(newList.size(), 2);
		assertEquals(sll.getNth(0), new Integer(1));
		assertEquals(sll.getNth(1), new Integer(2));
		assertEquals(newList.getNth(0), new Integer(3));
		assertEquals(newList.getNth(1), new Integer(4));
	}

	/**
	 * Test remove duplicates from the list.
	 */
	public void testRemoveDuplicates() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.removeDuplicates();
		assertEquals(sll.size(), 0);
		sll.add(1);
		sll.removeDuplicates();
		assertEquals(sll.size(), 1);
		sll.add(1);
		assertEquals(sll.size(), 2);
		sll.removeDuplicates();
		assertEquals(sll.size(), 1);
		sll.add(2);
		sll.add(2);
		sll.add(2);
		assertEquals(sll.size(), 4);
		sll.removeDuplicates();
		assertEquals(sll.size(), 2);
		sll.add(3);
		sll.add(3);
		sll.add(4);
		sll.add(5);
		sll.add(6);
		assertEquals(sll.size(), 7);
		sll.removeDuplicates();
		assertEquals(sll.size(), 6);
		assertEquals(sll.getNth(0), new Integer(1));
		assertEquals(sll.getNth(1), new Integer(2));
		assertEquals(sll.getNth(2), new Integer(3));
		assertEquals(sll.getNth(3), new Integer(4));
		assertEquals(sll.getNth(4), new Integer(5));
		assertEquals(sll.getNth(5), new Integer(6));
	}

	/**
	 * Test removal of the first match of the element from the list.
	 */
	@Test
	public void testRemove() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(1);
		sll.add(2);
		sll.add(3);
		sll.add(3);
		assertEquals(sll.remove(1), 0);
		assertEquals(sll.remove(3), 1);
		assertEquals(sll.size(), 2);
		assertEquals(sll.remove(3), 1);
		assertEquals(sll.size(), 1);
		assertEquals(sll.remove(5), -1);
		assertEquals(sll.size(), 1);
	}

	/**
	 * Test removal of the last match of the element from the list.
	 */
	@Test
	public void testRemoveLast() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		sll.add(1);
		sll.add(2);
		sll.add(3);
		sll.add(3);
		assertEquals(sll.removeLast(1), 0);
		assertEquals(sll.removeLast(3), 2);
		assertEquals(sll.size(), 2);
		assertEquals(sll.removeLast(3), 1);
		assertEquals(sll.size(), 1);
		assertEquals(sll.removeLast(5), -1);
		assertEquals(sll.size(), 1);
	}

	/**
	 * Test recursive reversal of the list.
	 */
	@Test
	public void testReverseRecursively() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		assertEquals(sll.getNth(0), null);
		sll.reverseRecursively();
		assertEquals(sll.getNth(0), null);

		sll.add(1);
		assertEquals(sll.getNth(0), new Integer(1));
		sll.reverseRecursively();
		assertEquals(sll.getNth(0), new Integer(1));

		sll = new SinglyLinkedList<Integer>();
		sll.add(1);
		sll.add(2);

		assertEquals(sll.getNth(0), new Integer(1));
		assertEquals(sll.getNth(1), new Integer(2));
		sll.reverseRecursively();
		assertEquals(sll.getNth(0), new Integer(2));
		assertEquals(sll.getNth(1), new Integer(1));

		sll = new SinglyLinkedList<Integer>();
		sll.add(1);
		sll.add(2);
		sll.add(3);

		assertEquals(sll.getNth(0), new Integer(1));
		assertEquals(sll.getNth(1), new Integer(2));
		assertEquals(sll.getNth(2), new Integer(3));
		sll.reverseRecursively();
		assertEquals(sll.getNth(0), new Integer(3));
		assertEquals(sll.getNth(1), new Integer(2));
		assertEquals(sll.getNth(2), new Integer(1));
	}

	/**
	 * Test iterative reversal of the list.
	 */
	@Test
	public void testReverseIteratively() {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		assertEquals(sll.getNth(0), null);
		sll.reverseIteratively();
		assertEquals(sll.getNth(0), null);

		sll.add(1);
		assertEquals(sll.getNth(0), new Integer(1));
		sll.reverseIteratively();
		assertEquals(sll.getNth(0), new Integer(1));

		sll = new SinglyLinkedList<Integer>();
		sll.add(1);
		sll.add(2);

		assertEquals(sll.getNth(0), new Integer(1));
		assertEquals(sll.getNth(1), new Integer(2));
		sll.reverseIteratively();
		assertEquals(sll.getNth(0), new Integer(2));
		assertEquals(sll.getNth(1), new Integer(1));

		sll = new SinglyLinkedList<Integer>();
		sll.add(1);
		sll.add(2);
		sll.add(3);

		assertEquals(sll.getNth(0), new Integer(1));
		assertEquals(sll.getNth(1), new Integer(2));
		assertEquals(sll.getNth(2), new Integer(3));
		sll.reverseIteratively();
		assertEquals(sll.getNth(0), new Integer(3));
		assertEquals(sll.getNth(1), new Integer(2));
		assertEquals(sll.getNth(2), new Integer(1));
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
