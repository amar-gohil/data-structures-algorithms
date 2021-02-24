package tree;

import java.util.Stack;

public class ZigZagTreeTraversal {

	static Node root = null;

	static class Node {
		Node left;
		int value;
		Node right;

		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	static void printLavel(Node root) {
		if (root == null)
			return;
		Stack<Node> currunt = new Stack<>();
		Stack<Node> next = new Stack<>();
		currunt.add(root);
		boolean leftToRight = false;
		while (!currunt.isEmpty()) {
			Node temp = currunt.pop();
			System.out.print(temp.value + " ");
			if (leftToRight) {
				if (temp.left != null)
					next.add(temp.left);
				if (temp.right != null)
					next.add(temp.right);
			} else {
				if (temp.right != null)
					next.add(temp.right);
				if (temp.left != null)
					next.add(temp.left);
			}
			if (currunt.isEmpty()) {
				System.out.println();
				leftToRight = !leftToRight;
				Stack<Node> tempStack = next;
				next = currunt;
				currunt = tempStack;
			}
		}
	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(6);
		root.left.left = new Node(4);
		root.left.right = new Node(8);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(20);
		root.right = new Node(10);
		root.right.left = new Node(16);
		root.right.right = new Node(7);
		printLavel(root);
	}
}
