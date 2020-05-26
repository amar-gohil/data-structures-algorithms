package tree;

import java.util.HashMap;
import java.util.Map;

public class BTFromPreorderAndInorder {

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

	static Node buildTree(int in[], int pre[], int f, int l, Map<Integer, Integer> map) {
		if (f > l)
			return null;
		Node tempNode = new Node(pre[preIndex++]);
		if (f == l)
			return tempNode;
		int inIndex = map.get(tempNode.value);
		tempNode.left = buildTree(in, pre, f, inIndex - 1, map);
		tempNode.right = buildTree(in, pre, inIndex + 1, l, map);
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
		int in[] = new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
		int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };
		int len = in.length;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}

		Node root = buildTree(in, pre, 0, len - 1, map);
		inorder(root);
	}
}
