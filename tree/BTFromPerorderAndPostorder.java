package tree;

import java.util.Arrays;

public class BTFromPerorderAndPostorder {
	static Node root;
	static int preindex = 0;

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

	static Node buildTree(int[] pre, int[] post, int f, int l, int size) {
		if (preindex >= size || f > l)
			return null;
		Node temp = new Node(pre[preindex++]);
		if (f == l || preindex >= size)
			return temp;
		int i;
		for (i = f; i < l; i++) {
			if (post[i] == pre[preindex])
				break;
		}
		if (i <= l) {
			temp.left = buildTree(pre, post, f, i, size);
			temp.right = buildTree(pre, post, i + 1, l, size);
		}
		return temp;
	}

	static Node buildTreeWithMoreSpaceUse(int[] pre, int[] post){
		int N = pre.length;
        if (N == 0) return null;
        Node root = new Node(pre[0]);
        if (N == 1) return root;

        int L = 0;
        for (int i = 0; i < N; ++i)
            if (post[i] == pre[1])
                L = i+1;

        root.left = buildTreeWithMoreSpaceUse(Arrays.copyOfRange(pre, 1, L+1),
                                         Arrays.copyOfRange(post, 0, L));
        root.right = buildTreeWithMoreSpaceUse(Arrays.copyOfRange(pre, L+1, N),
                                          Arrays.copyOfRange(post, L, N-1));
        return root;
	}
	static void inorder(Node root) {
		if (root != null) {
			System.out.print(root.value + " ");
			inorder(root.left);			
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
		int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
		int len = pre.length;
		root = buildTree(pre, post, 0, len - 1, len);
		inorder(root);
	}
}
