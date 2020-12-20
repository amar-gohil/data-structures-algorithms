package tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindLevelMaximumSumBT {

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

	static int maxLevelSum(Node root) {
		if (root == null)
			return 0;
		int result = root.value;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		int level = 0;
		int maxLevel = 0;
		while (!q.isEmpty()) {
			int count = q.size();
			int sum = 0;
			while (count-- > 0) {
				Node temp = q.poll();
				sum = sum + temp.value;
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
			if(sum>result) maxLevel = level;
			level++;
			result = Math.max(result, sum);
		}
		System.out.println(maxLevel +"level");
		return result;
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
		System.out.println(maxLevelSum(root));
	}
}
