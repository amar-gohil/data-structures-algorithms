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

	static boolean isBST3(Node node, int min, int max) {
		if (node == null)
			return true;
		if (node.value < min || node.value > max)
			return false;
		return (isBST3(node.left, min, node.value - 1) && isBST3(node.right, node.value + 1, max));
	}

	static boolean isBST4(Node node, Node l, Node r) {
		if (node == null)
			return true;
		if (l != null && node.value <= l.value)
			return false;
		if (r != null && node.value >= r.value)
			return false;
		return (isBST4(node.left, l, node) && isBST4(node.right, node, r));
	}

	public static void main(String[] args) {
		root = new Node(3);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right = new Node(5);
		System.out.println(isBST4(root, null, null));
	}
}
