package stack;

import java.util.Stack;

public class EvaluationOfPostfixExpressions {
	static Object[] postfix = { 2, 3, 4, '*', '+', 16, 2, 3, '^', '/', '-' };
	static Stack<Integer> stack = new Stack<>();

	static int evaluation() {
		int l = postfix.length;
		for (int i = 0; i < l; i++) {
			Object value = postfix[i];
			if (value instanceof Number) {
				stack.push((Integer) value);
			} else {
				int b = stack.pop();
				int a = stack.pop();
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
