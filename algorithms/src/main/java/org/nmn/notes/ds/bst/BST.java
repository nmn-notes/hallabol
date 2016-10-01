package org.nmn.notes.ds.bst;

/**
 * Binary Search Tree.
 *
 * @author nmn-notes
 */
public class BST {

	private Node root;

	private int size = 0;

	/**
	 * Insert data in BST recursively.
	 * @param data to be inserted into BST.
	 * @return <code>true</code> if element is inserted successfully;
	 * 		   <code>false</code> otherwise.
	 */
	public boolean insertRecursively(Integer data) {
		root = insertRecursively(data, root);
		return true;
	}

	private Node insertRecursively(Integer data, Node node){
		if (node == null) {
			size++;
			return new Node(data);
		}
		else if (data < node.data) {
			node.left = insertRecursively(data, node.left);
		}
		else {
			node.right = insertRecursively(data, node.right);
		}
		return node;
	}

	/**
	 * Checks if data is present in the BST.
	 * @param data to be checked.
	 * @return <code>true</code> if data is available in BST;
	 * 		   <code>false</code> otherwise.
	 */
	public boolean hasElement(Integer data) {
		Node current = root;
		while (current != null) {
			if (current.data.equals(data)) {
				return true;
			}
			else if (data < current.data) {
				current = current.left;
			}
			else {
				current = current.right;
			}
		}
		return false;
	}
	/**
	 * Size of the BST.
	 * @return total number of elements in BST.
	 */
	public int size() {
		return size;
	}

	/**
	 * Node of BST.
	 */
	private static class Node {

		/** The data. */
		Integer data;

		/** The left. */
		Node left;

		/** The right. */
		Node right;

		Node(Integer data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}

	}
}
