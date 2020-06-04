package tree;

public class BSTFromPreorder {
	static Node root = null;
	static int preIndex = 0;

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

	static Node buildTree(int[] pre, int f, int l, int size) {
		if (preIndex >= size || f > l)
			return null;

		Node node = new Node(pre[preIndex++]);
		if (l == f)
			return node;

		int i;
		for (i = f; i <= l; ++i) {
			if (pre[i] > node.value) {
				break;
			}
		}

		node.left = buildTree(pre, preIndex, i -1, size);
		node.right = buildTree(pre, i , l, size);
		return node;
	}

	static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}

	public static void main(String[] args) {
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		root = buildTree(pre, 0, pre.length - 1, pre.length);
		inorder(root);
	}
}
