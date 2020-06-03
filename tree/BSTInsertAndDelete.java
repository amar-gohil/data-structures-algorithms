package tree;

public class BSTInsertAndDelete {

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
			if (node.left == null) {
				node.left = new Node(value);
			} else {
				insert(node.left, value);
			}
		} else if (value > node.value) {
			if (node.right == null) {
				node.right = new Node(value);
			} else {
				insert(node.right, value);
			}
		}

	}

	static Node deleteInorderSuccessor(Node node, int value) {
		if (node == null)
			return node;
		if (value < node.value)
			node.left = deleteInorderSuccessor(node.left, value);
		else if (value > node.value) {
			node.right = deleteInorderSuccessor(node.right, value);
		} else {
			if (node.left == null)
				return node.right;
			else if (node.right == null)
				return node.left;
			node.value = minValue(node.right);
			node.right = deleteInorderSuccessor(node.right, node.value);
		}
		return node;
	}

	static int minValue(Node node) {
		int minValue = node.value;
		while (node.left != null) {
			minValue = node.left.value;
			node = node.left;
		}
		return minValue;
	}

	static void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.value + " ");
			inOrder(node.right);
		}
	}

	public static void main(String[] args) {
		 insert(root,50); 
	     insert(root,30);
	     insert(root,10);
	     insert(root,20); 
	     insert(root,40); 
	     insert(root,70); 
	     insert(root,60); 
	     insert(root,80); 
		 inOrder(root);
		 deleteInorderSuccessor(root,50); 
		 System.out.println();
		 inOrder(root);
	}
}
