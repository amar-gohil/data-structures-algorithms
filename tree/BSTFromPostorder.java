package tree;

public class BSTFromPostorder {

	static int postIndex = 0;

	static class Node {
		Node left;
		int value;
		Node right;

		Node(int value) {
			this.left = null;
			this.value = value;
			this.right = null;
		}
	}

	static Node buildTree(int[] postorder, int f, int l) {
		if (f > l)
			return null;
		Node node = new Node(postorder[l]);
		int i;
		for (i = l; i >= f; i--) {
			if (postorder[i] < node.value) {
				break;
			}
		}
		node.right = buildTree(postorder, i + 1, l - 1);
		node.left = buildTree(postorder, f, i);
		return node;
	}

	static Node buildTreeWithMinMax(int[] postorder, int key, int min, int max) {
		if (postIndex < 0)
			return null;

		Node node = null;
		if (key > min && key < max) {
			node = new Node(key);
			postIndex = postIndex - 1;
			if (postIndex > 0) {
				node.right = buildTreeWithMinMax(postorder, postorder[postIndex], key, max);
				node.left = buildTreeWithMinMax(postorder, postorder[postIndex], min, key);
			}
		}
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
		int[] postorder = { 8, 12, 10, 16, 25, 20, 15 };
		postIndex = postorder.length - 1;
		Node root = buildTreeWithMinMax(postorder, postorder[postIndex], Integer.MIN_VALUE, Integer.MAX_VALUE);
		inorder(root);
	}
}
