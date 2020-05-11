package stack;

import java.util.Stack;

public class ConversionToInfix {

	static Stack<String> stack = new Stack<>();

	static String postfixToInfix() {
		String[] postfix = { "a", "b", "+", "e", "f", "/", "*" };
		for (String string : postfix) {
			if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
				String a = stack.pop();
				String b = stack.pop();
				String temp = "(" + b + string + a + ")";
				stack.push(temp);
			} else {
				stack.push(string);
			}
		}

		return stack.isEmpty() ? "-1" : stack.pop();
	}

	static String prefixToInfix() {
		String[] prefix = { "*", "+", "a", "b", "/", "e", "f" };
		int l = prefix.length - 1;
		for (int i = l; i > -1; i--) {
			String string = prefix[i];
			if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
				String a = stack.pop();
				String b = stack.pop();
				String temp = "(" + a + string + b + ")";
				stack.push(temp);
			} else {
				stack.push(string);
			}
		}

		return stack.isEmpty() ? "-1" : stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(postfixToInfix());
	}
}
