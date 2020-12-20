package tree;

public class FindInorderSuccessorInBinarySearchTree {
	static Node head;

	static class Node {
		int data;
		Node left, right, parent;

		Node(int data) {
			this.data = data;
			left = right = parent = null;
		}
	}

	static Node insert(Node node, int data) {
		if (node == null) {
			return new Node(data);
		} else {
			Node temp = null;
			if (data < node.data) {
				temp = insert(node.left, data);
				node.left = temp;
				temp.parent = node;
			} else {
				temp = insert(node.right, data);
				node.right = temp;
				temp.parent = node;
			}
			return node;
		}
	}

	static void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(" " + node.data);
			inOrder(node.right);
		}
	}

	static Node findInOrderSuccessor(Node inputNode) {
		if (inputNode == null)
			return null;
		if (inputNode.right != null) {
			return findLeft(inputNode.right);
		}

		Node parent = inputNode.parent;
		Node child = inputNode;
		while (parent.right == child) {
			if (parent.parent == null)
				return null;
			child = parent;
			parent = parent.parent;
		}
		return parent;
	}

	static Node findLeft(Node left) {
		if (left.left == null)
			return left;
		return findLeft(left.left);
	}

	public static void main(String[] args) {
		head = insert(head, 20);
		head = insert(head, 8);
		head = insert(head, 22);
		head = insert(head, 4);
		head = insert(head, 12);
		head = insert(head, 10);
		head = insert(head, 14);
		inOrder(head);
		System.out.println();
		System.out.println(head.left.data + " in oderd successor is " + findInOrderSuccessor(head.left).data);
		System.out.println(head.left.right.left.data + " in oderd successor is " + findInOrderSuccessor(head.left.right.left).data);
		System.out.println(head.left.right.right.data + " in oderd successor is " + findInOrderSuccessor(head.left.right.right).data);
	}
}
