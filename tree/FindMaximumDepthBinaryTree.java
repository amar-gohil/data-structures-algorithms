package tree;

public class FindMaximumDepthBinaryTree {
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

	static int maxDepth(Node node) {
		if (node == null) {
			return 0;
		} else {
			int ld = maxDepth(node.left);
			int rd = maxDepth(node.right);
			return Math.max(ld, rd) + 1;
		}
	}

	// other way 
	static int getHeight(Node node){
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
	public static void main(String[] args) {
		insert(root, 3);
		insert(root, 4);
		insert(root, 5);
		insert(root, 2);
		insert(root, 1);
		inOrder(root);
		System.out.println(getHeight(root));
	}
}
