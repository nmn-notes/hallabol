package org.nmn.notes.ds.linkedlist;

/**
 * Singly Linked List. This implementation is not threadsafe.
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
	 * Counts the number of times a given element occurs in the list.
	 * 
	 * @param e element
	 * @return count
	 */
	public int count(E e) {
		int count = 0;
		Node<E> current = header;
		while (current != null) {
			if (current.data.equals(e)) {
				count++;
			}
			current = current.next;
		}
		return count;
	}

	/**
	 * Get nth element in the singly linkedlist.
	 * 
	 * @param index the index of the node.
	 * @return element if node is available;
	 * 		   null otherwise. 
	 */
	public E getNth(int index) {
		Node<E> current = header;
		int currentIndex = 0;
		while (currentIndex < index && current != null) {
			current = current.next;
			currentIndex++;
		}
		return current != null ? current.data : null;
	}

	/**
	 * Deletes the entire list.
	 * @return <code>true</code> if list was deleted successfully;
	 * 		   <code>false</code> otherwise.
	 */
	public boolean deleteList() {
		Node<E> current = header;
		while (current != null) {
			Node<E> prev = current;
			current = current.next;
			prev.next = null;
		}
		header = null;
		size = 0;
		return true;
	}

	/**
	 * Pop 1st element from the list.
	 * 
	 * @return first element in the list if available;
	 * 		   null otherwise.
	 */
	public E pop() {
		Node<E> current = header;
		if (current == null) {
			return null;
		}
		header = header.next;
		E element = current.data;
		current.next = null;
		return element;
	}

	/**
	 * Insert a new node at specified index in the list.
	 * 
	 * @param index at which node has to be inserted.
	 * @param e element of the new node.
	 * @return <code>true</code> if node is inserted at specified index;
	 * 		   <code>false</code> otherwise.
	 */
	public boolean insertNth(int index, E e) {
		//boundary conditions.
		if (index < 0 || index > size) {
			return false;
		}

		//Insert at the head.
		if (index == 0) {
			return addFirst(e);
		}

		Node<E> current = header;
		int currentIndex = 1;

		while (current != null) {
			if (currentIndex == index) {
				Node<E> newNode = new Node<E>(e, current.next);
				current.next = newNode;
				size++;
				return true;
			}
			current = current.next;
			currentIndex++;
		}

		return false;
	}

	/**
	 * Insert element at the correct sorted position in the list.
	 * Will work only when the list is already sorted and inserted element is {@link Comparable}.
	 * 
	 * @param e element to be inserted.
	 * @return index at which the element is sorted.
	 */
	public int sortedInsert(E e) {
		Node<E> current = header;

		//insert node at the beginning of the list.
		if (current == null || current.compareTo(e) > 0) {
			addFirst(e);
			return 0;
		}

		Node<E> next = current.next;
		int index = 1;
		while (current != null && next != null) {
			if (current.compareTo(e) < 0 && next.compareTo(e) > 0) {
				//insert node here.
				Node<E> newNode = new Node<E>(e, current.next);
				current.next = newNode;
				size++;
				return index;
			}
			current = next;
			next = next.next;
			index++;
		}

		//insert node at the end of the list.
		current.next = new Node<E>(e, null);
		size++;
		return index;
	}

	/**
	 * Sort the list.
	 */
	public void insertSort() {
		Node<E> current = header;
		header = null;
		size = 0;
		while (current != null) {
			Node<E> next = current.next;
			current.next = null;
			sortedInsert(current.data);
			current = next;
		}
	}

	/**
	 * Split the list into two sublists - one for the first half, and one for the back half.
	 * If the number of elements is odd, the extra element should go in the front list.
	 * @return the second list 
	 */
	public SinglyLinkedList<E> frontBackSplit() {
		SinglyLinkedList<E> newList = new SinglyLinkedList<E>();

		//base condition.
		if (header == null) {
			return newList;
		}

		Node<E> slow = header;
		Node<E> fast = slow.next;
		int count = 1;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			count++;
		}
		newList.header = slow.next;
		slow.next = null;
		//update size
		newList.size = size - count;
		size = count;
		return newList;
	}

	/**
	 * Delete any duplicate nodes from the sorted increasing list.
	 */
	public void removeDuplicates() {
		Node<E> current = header;
		while (current != null) {
			Node<E> next = current.next;
			while (next != null && current.data.equals(next.data)) {
				next = next.next;
				size--;
			}
			current.next = next;
			current = current.next;
		}
	}

	/**
	 * Remove first match of the element in the list.
	 * 
	 * @param e element to be removed
	 * @return index of the element if removed; -1 otherwise.
	 */
	public int remove(E e) {
		Node<E> current = header;

		if (current == null) {
			return -1;
		}
		else if (current.data.equals(e)) {
			header = header.next;
			size--;
			return 0;
		}

		int index = 1;
		Node<E> prev = current;
		current = current.next;

		while (current != null) {
			if (current.data.equals(e)) {
				prev.next = current.next;
				size--;
				return index;
			}
			prev = current;
			current = current.next;
			index++;
		}
		return -1;
	}

	/**
	 * Remove last match of the element in the list.
	 * 
	 * @param e element to be removed
	 * @return index of the element if removed; -1 otherwise.
	 */
	public int removeLast(E e) {
		Node<E> current = header;
		Node<E> prev = header;

		Node<E> lastMatchPrev = null;
		int lastMatchIndex = -1;
		if (current.data.equals(e)) {
			lastMatchPrev = current;
			lastMatchIndex = 0;
		}

		int index = 1;
		prev = current;
		current = current.next;

		while (current != null) {
			if (current.data.equals(e)) {
				lastMatchPrev = prev;
				lastMatchIndex = index;
			}
			prev = current;
			current = current.next;
			index++;
		}

		if (lastMatchPrev != null) {
			//1st element
			if (lastMatchIndex == 0) {
				header = lastMatchPrev.next;
			}
			else {
				lastMatchPrev.next = lastMatchPrev.next.next;
			}
			size--;
			return lastMatchIndex;
		}

		return -1;
	}

	/**
	 * Get the current length of the linkedlist.
	 * 
	 * @return length of the linkedlist.
	 */
	public int length() {
		return size;
	}

	/**
	 * Get the current length of the linkedlist.
	 * 
	 * @return length of the linkedlist.
	 */
	public int size() {
		int size = 0;
		Node<E> current = header;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	/**
	 * Prints all the elements in the list.
	 */
	public void printList() {
		Node<E> current = header;
		while (current != null) {
			System.out.println("Element: " + current.data);
		}
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
	private static class Node<E> implements Comparable<E> {

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

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public int compareTo(E o) {
			if (o instanceof Comparable) {
				return ((Comparable)data).compareTo((Comparable)o);
			}
			return -1;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}

	}

}
