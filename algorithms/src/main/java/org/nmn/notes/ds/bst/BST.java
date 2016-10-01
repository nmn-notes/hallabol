package org.nmn.notes.ds.bst;

import java.util.ArrayList;

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
		else if (data <= node.data) {
			node.left = insertRecursively(data, node.left);
		}
		else {
			node.right = insertRecursively(data, node.right);
		}
		return node;
	}

	/**
	 * Insert data in BST iteratively.
	 * 
	 * @param data to be inserted in BST.
	 * @return <code>true</code> if data inserted successfully;
	 * 		   <code>false</code> otherwise.
	 */
	public boolean insertIteratively(Integer data) {
		if (root == null) {
			root = new Node(data);
			size++;
			return true;
		}

		Node current = root;
		Node prev = null;
		boolean left = true;
		Node newNode = new Node(data);

		while(current != null) {
			prev = current;
			if (data <= current.data) {
				left = true;
				current = current.left;
			}
			else {
				left = false;
				current = current.right;
			}
		}

		if (left) {
			prev.left = newNode;
		}
		else {
			prev.right = newNode;
		}
		size++;
		return true;
	}

	/**
	 * Returns minimum value in BST.
	 * @return minimum value in BST if available; null otherwise.
	 */
	public Integer minValue() {
		return (root != null)? minValue(root) : null;
	}

	private Integer minValue(Node current) {
		if (current.left == null) {
			return current.data;
		}
		return minValue(current.left);
	}

	/**
	 * Returns maximum value in BST.
	 * @return maximum value in BST if available, null otherwise.
	 */
	public Integer maxValue() {
		return (root != null)? maxValue(root) : null;
	}

	private Integer maxValue(Node current) {
		if (current.right == null) {
			return current.data;
		}
		return maxValue(current.right);
	}

	/**
	 * Given a sum, return true if the tree has a root-to-leaf path such that adding up all 
	 * the values along the path equals the given sum. Return false if no such path can be found.
	 * 
	 * @param sum from root-to-leaf path
	 * @return <code>true</code> if root-to-leaf path has sum;
	 *		   <code>false</code> otherwise.
	 */
	public boolean hasPathSum(Integer sum) {
		return hasPathSum(sum, root);
	}

	private boolean hasPathSum(Integer sum, Node current) {
		if (current == null) {
			return sum == 0;
		}
		return hasPathSum(sum - current.data, current.left) || hasPathSum(sum - current.data, current.right);
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
	 * Print in-order elements of the tree.
	 * 
	 * @return {@link ArrayList} of in-order representation of tree.
	 */
	public ArrayList<Integer> printInOrder() {
		ArrayList<Integer> result = new ArrayList<Integer>(size);
		printInOrder(root, result);
		return result;
	}

	private void printInOrder(Node node, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}
		printInOrder(node.left, list);
		System.out.print(node.data + " ");
		list.add(node.data);
		printInOrder(node.right, list);
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
