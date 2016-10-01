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
	 * Print pre-order elements of the tree.
	 * 
	 * @return {@link ArrayList} of pre-order representation of tree.
	 */
	public ArrayList<Integer> printPreOrder() {
		ArrayList<Integer> result = new ArrayList<Integer>(size);
		System.out.print("PreOrder: ");
		printPreOrder(root, result);
		System.out.println();
		return result;
	}

	private void printPreOrder(Node node, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		list.add(node.data);
		printPreOrder(node.left, list);
		printPreOrder(node.right, list);
	}

	/**
	 * Print in-order elements of the tree.
	 * 
	 * @return {@link ArrayList} of in-order representation of tree.
	 */
	public ArrayList<Integer> printInOrder() {
		ArrayList<Integer> result = new ArrayList<Integer>(size);
		System.out.print("InOrder: ");
		printInOrder(root, result);
		System.out.println();
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
	 * Print post-order elements of the tree.
	 * 
	 * @return {@link ArrayList} of post-order representation of tree.
	 */
	public ArrayList<Integer> printPostOrder() {
		ArrayList<Integer> result = new ArrayList<Integer>(size);
		System.out.print("PostOrder: ");
		printPostOrder(root, result);
		System.out.println();
		return result;
	}

	private void printPostOrder(Node node, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}
		printPostOrder(node.left, list);
		printPostOrder(node.right, list);
		System.out.print(node.data + " ");
		list.add(node.data);
	}

	/**
	 * Compute the number of nodes along the longest path from the root node down 
	 * to the farthest leaf node. The maxDepth of the empty tree is 0.
	 * 
	 * @return maximum depth of the tree.
	 */
	public int maxDepth() {
		return maxDepth(root, 0);
	}

	private int maxDepth(Node current, int depth) {
		if (current == null) {
			return depth;
		}
		return Math.max(maxDepth(current.left, depth + 1), maxDepth(current.right, depth + 1));
	}

	/**
	 * Change a tree so that the roles of the left and right pointers are swapped at every node. 
	 */
	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		if (node == null) {
			return;
		}
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		mirror(node.left);
		mirror(node.right);
	}

	/**
	 * For each node in a binary search tree, create a new duplicate node, 
	 * and insert the duplicate as the left child of the original node.
	 */
	public void doubleTree() {
		doubleTree(root);
	}

	private void doubleTree(Node node) {
		if (node == null) {
			return;
		}
		doubleTree(node.left);
		//insert duplicate node as left child.
		Node newNode = new Node(node.data);
		newNode.left = node.left;
		node.left = newNode;
		doubleTree(node.right);
	}

	/**
	 * Given two binary trees, return true if they are structurally identical -- 
	 * they are made of nodes with the same values arranged in the same way.
	 */
	public static boolean sameTree(BST bst1, BST bst2) {
		return sameTree(bst1.root, bst2.root);
	}

	private static boolean sameTree(Node node1, Node node2) {
		//both nodes are null
		if (node1 == null && node2 == null) {
			return true;
		}
		//only one node is null
		else if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
			return false;
		}
		//both nodes are NOT null but data is not equal
		else if (!node1.data.equals(node2.data)) {
			return false;
		}
		//recursively call the routine on left and right child tree.
		return sameTree(node1.left, node2.left) & sameTree(node1.right, node2.right);
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
