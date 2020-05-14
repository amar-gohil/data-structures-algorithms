package stack;

import java.util.Stack;

public class EvaluationOfPrefixExpressions {
	static Object[] prefix = { '-', '+', 2, '*', 3, 4, '/', 16, '^', 2, 3 };
	static Stack<Integer> stack = new Stack<>();

	static int evaluation() {
		int l = prefix.length - 1;
		for (int i = l; i > -1; i--) {
			Object value = prefix[i];
			if (value instanceof Number) {
				stack.push((Integer) value);
			} else {
				int a = stack.pop();
				int b = stack.pop();
				if (value.equals('+')) {
					stack.push(a + b);
				} else if (value.equals('-')) {
					stack.push(a - b);
				} else if (value.equals('*')) {
					stack.push(a * b);
				} else if (value.equals('/')) {
					stack.push(a / b);
				} else if (value.equals('^')) {
					stack.push((int) Math.pow(a, b));
				}
			}
		}
		return stack.isEmpty() ? -1 : stack.pop();
	}

	public static void main(String[] args) {
		System.out.println(evaluation());
	}
}
