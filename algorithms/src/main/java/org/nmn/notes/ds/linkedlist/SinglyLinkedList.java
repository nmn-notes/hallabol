package org.nmn.notes.ds.linkedlist;

/**
 * Singly Linked List.
 *
 * @author nmn-notes
 * @param <E> the element type
 */
public class SinglyLinkedList<E> {

	/** The header. */
	private Node<E> header;
	
	/** The size. */
	private int size;

	/**
	 * Add element at the end of the linkedlist.
	 * @param element to be added to the linked.
	 * @return <code>true</code> if added successfully;
	 * 		   <code>false</code> otherwise.
	 */
	public boolean add(E element) {
		Node<E> newNode = new Node<E>(element, null);
		if (header == null) {
			header = newNode;
		}
		else {
			Node<E> lastNode = getLast();
			lastNode.next = newNode;
		}
		size++;
		return true;
	}

	/**
	 * Add element at the beginning of the linkedlist.
	 * @param element to be added to the linked.
	 * @return <code>true</code> if added successfully;
	 * 		   <code>false</code> otherwise.
	 */
	public boolean addFirst(E element) {
		Node<E> newNode = new Node<E>(element, header);
		header = newNode;
		size++;
		return true;
	}

	/**
	 * Get element at index of the singly linkedlist.
	 * 
	 * @param index the index of the node.
	 * @return element if node is available;
	 * 		   null otherwise. 
	 */
	public E get(int index) {
		Node<E> current = header;
		int currentIndex = 0;
		while (currentIndex < index && current != null) {
			current = current.next;
			currentIndex++;
		}
		return current != null ? current.data : null;
	}

	/**
	 * Get the current size of the linkedlist.
	 * 
	 * @return size of the linkedlist.
	 */
	public int size() {
		return size;
	}

	/**
	 * Gets the last element of the linkedlist.
	 *
	 * @return the last node in the list.
	 */
	private Node<E> getLast() {
		Node<E> current = header;
		while(current != null && current.next != null) {
			current = current.next;
		}
		return current;
	}

	/**
	 * Singly linkedlist node.
	 *
	 * @param <E> the element type
	 */
	private static class Node<E> {

		/** The data. */
		E data;

		/** The next. */
		Node<E> next;

		/**
		 * Instantiates a new node.
		 *
		 * @param data the data.
		 * @param next the next.
		 */
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
}
