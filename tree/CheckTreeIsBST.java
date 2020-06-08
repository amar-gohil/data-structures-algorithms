package tree;

import tree.BSTInsertAndDelete.Node;

public class CheckTreeIsBST {
	static Node root = null;

	static class Node {
		Node left;
		int value;
		Node right;

		Node(int value) {
			left = null;
			this.value = value;
			right = null;
		}
	}

	// This will not work in all cases
	static boolean isBST1(Node node) {
		if (node == null)
			return true;
		if (node.left != null && node.left.value > node.value)
			return false;
		if (node.right != null && node.right.value < node.value)
			return false;
		if (!isBST1(node.left) || !isBST1(node.right))
			return false;
		return true;
	}

	static boolean isBST2(Node node) {
		if (node == null)
			return true;
		if (node.left != null && maxValue(node.left) > node.value)
			return false;
		if (node.right != null && minValue(node.right) < node.value)
			return false;
		if (!isBST2(node.left) || !isBST2(node.right))
			return false;
		return true;
	}

	static int maxValue(Node node) {
		int maxValue = node.value;
		while (node.right != null) {
			maxValue = node.right.value;
			node = node.right;
		}
		return maxValue;
	}
	static int minValue(Node node) {
		int minValue = node.value;
		while (node.left != null) {
			minValue = node.left.value;
			node = node.left;
		}
		return minValue;
	}

	public static void main(String[] args) {
		root = new Node(3);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right = new Node(5);
		System.out.println(isBST2(root));
	}
}
