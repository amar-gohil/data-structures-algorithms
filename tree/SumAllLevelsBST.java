package tree;

public class SumAllLevelsBST {
	static Node root = null;

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

	static void insert(Node node, int value) {
		if (root == null) {
			root = new Node(value);
		} else if (value < node.value) {
			if (node.left != null) {
				insert(node.left, value);
			} else {
				node.left = new Node(value);
			}
		} else {
			if (node.right != null) {
				insert(node.right, value);
			} else {
				node.right = new Node(value);
			}
		}
	}

	static void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.value);
			inOrder(node.right);
		}
	}

	static int getHeight(Node node) {
		if (node == null)
			return 0;

		int left = 0;
		if (node.left != null)
			left = getHeight(node.left);

		int right = 0;
		if (node.right != null)
			right = getHeight(node.right);

		return (Math.max(left, right) + 1);
	}

	static void calculateLevelSum(Node node, int level, int sum[]) {
		if (node == null)
			return;
		sum[level] += node.value;

		// Recursive call for left and right sub-tree
		calculateLevelSum(node.left, level + 1, sum);
		calculateLevelSum(node.right, level + 1, sum);
	}

	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(4);
		root.right = new Node(8);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(7);
		root.right.right = new Node(9);
		int levels = getHeight(root);
		int sum[] = new int[levels];
		calculateLevelSum(root, 0, sum);
		printArr(sum, sum.length);
	}

	static void printArr(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.println(arr[i]);
	}
}
