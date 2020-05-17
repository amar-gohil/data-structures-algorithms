package stack;

import java.util.Stack;

public class PrefixToBET {

	static Stack<Node> stack = new Stack<>();

	static class Node {
		Node left;
		String value;
		Node right;

		Node(Node left, String value, Node right) {
			this.left = left;
			this.value = value;
			this.right = right;
		}
	}

	static Node conversion() {
		String[] prefix = { "*", "+", "a", "b", "/", "e", "f" };
		int l = prefix.length - 1;
		for (int i = l; i > -1; i--) {
			String string = prefix[i];
			if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")
					|| string.equals("^")) {
				Node a = stack.pop();
				Node b = stack.pop();
				Node temp = new Node(a, string, b);
				stack.push(temp);
			} else {
				Node node = new Node(null, string, null);
				stack.push(node);
			}
		}

		return stack.pop();
	}

	static void display(Node node) {
		if (node == null)
			return;
		display(node.left);
		display(node.right);
		System.out.print(node.value + " ");
	}

	public static void main(String[] args) {
		Node root = conversion();
		display(root);
	}

}
