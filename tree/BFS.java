package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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

	static void insert(Node node, int value) {
		if (root == null) {
			root = new Node(value);
		} else if (value < node.value) {
			if (node.left != null) {
				insert(node.left, value);
			} else {
				node.left = new Node(value);
			}
		} else if (value > node.value) {
			if (node.right != null) {
				insert(node.right, value);
			} else {
				node.right = new Node(value);
			}
		}
	}

	// BFS
	static void levelOrderTraversal(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.value + " ");
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);

		}
	}

	public static void main(String[] args) {
		root = new Node(3);
		root.left = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right = new Node(5);
		levelOrderTraversal(root);
	}
}
