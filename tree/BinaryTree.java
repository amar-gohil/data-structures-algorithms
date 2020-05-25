package tree;

public class BinaryTree {

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

	static void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.value);
			inOrder(node.right);
		}
	}

	static void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.value);
			inOrder(node.left);
			inOrder(node.right);
		}
	}

	static void postOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			inOrder(node.right);
			System.out.println(node.value);
		}
	}

	static int find(Node node, int value) {
		if (node != null) {
			if (node.value == value)
				return node.value;
			else if (value < node.value) {
				return find(node.left, value);
			} else if (value > node.value) {
				return find(node.right, value);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		insert(root, 2);
		insert(root, 1);
		insert(root, 3);
		inOrder(root);
		System.out.println(find(root, 32));
	}
}
