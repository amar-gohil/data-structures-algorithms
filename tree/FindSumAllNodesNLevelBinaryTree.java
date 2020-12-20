package tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindSumAllNodesNLevelBinaryTree {
	static class Node {
		Node left;
		int value;
		Node right;

		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	static int sumNodeNLevel(Node root, int n) {
		if (root == null)
			return 0;
		int sum = 0;
		int level = 0;
		int flag = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int count = q.size();
			while (count-- > 0) {
				Node temp = q.poll();
				if (level == n) {
					sum = sum + temp.value;
					flag = 1;
				} else {
					if (temp.left != null)
						q.add(temp.left);
					if (temp.right != null)
						q.add(temp.right);
				}
			}
			if (flag == 1) {
				break;
			}
			level++;
		}
		return sum;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(8);
		root.right.right.left = new Node(6);
		root.right.right.right = new Node(7);
		System.out.println(sumNodeNLevel(root, 0));
	}
}
