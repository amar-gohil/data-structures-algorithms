package stack;

import java.util.Stack;

public class PostfixToBET {

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
		String[] postfix = { "a", "b", "*", "c", "/", "e", "f", "/", "g", "*", "+", "k", "+", "x", "y", "*","-" };
		for (String string : postfix) {
			if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/") || string.equals("^")) {
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
