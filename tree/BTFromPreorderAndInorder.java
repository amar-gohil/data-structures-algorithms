package tree;

public class BTFromPreorderAndInorder {

	static Node root = null;
	static int preIndex = 0;

	static class Node {
		Node left;
		char value;
		Node right;

		Node(char value) {
			left = null;
			this.value = value;
			right = null;
		}
	}

	static int findIndexInInorder(char in[], int f, int l, int v) {
		int i;
		for (i = f; i <= l; i++) {
			if (in[i] == v)
				return i;
		}
		return i;
	}

	static Node buildTree(char in[], char pre[], int f, int l) {
		if (f > l)
			return null;
		Node tempNode = new Node(pre[preIndex++]);
		if (f == l)
			return tempNode;
		int inIndex = findIndexInInorder(in, f, l, tempNode.value);
		tempNode.left = buildTree(in, pre, f, inIndex - 1);
		tempNode.right = buildTree(in, pre, inIndex + 1, l);
		return tempNode;
	}

	static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}

	public static void main(String[] args) {
		char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		int len = in.length;
		Node root = buildTree(in, pre, 0, len - 1);
		inorder(root);
	}
}
