package tree;

import java.util.HashMap;
import java.util.Map;

public class BTFromPostorderAndInorder {

	static Node root = null;
	static int postIndex = 0;

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

	static Node buildTree(int in[], int post[], int f, int l, Map<Integer, Integer> map) {
		if (f > l)
			return null;
		Node tempNode = new Node(post[postIndex--]);
		if (f == l)
			return tempNode;
		int inIndex = map.get(tempNode.value);

		tempNode.right = buildTree(in, post, inIndex + 1, l, map);
		tempNode.left = buildTree(in, post, f, inIndex - 1, map);

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
		int in[] = new int[] { 4, 8, 2, 5, 1, 6, 3, 7 };
		int post[] = new int[] { 8, 4, 5, 2, 6, 7, 3, 1 };
		int len = in.length;
		postIndex = len - 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		Node root = buildTree(in, post, 0, len - 1, map);
		inorder(root);
	}
}
