
package stack;

public class StackUsingArray {

	static int top = -1;
	static int[] stack = new int[5];

	static boolean isEmpty() {
		return top == -1 ? true : false;
	}

	static boolean isFull() {
		return top == stack.length - 1 ? true : false;
	}

	static void push(int value) {
		if (isFull()) {
			System.out.println("stack overflow");
		} else {
			top++;
			stack[top] = value;
		}
	}

	static void pop() {
		if (isEmpty()) {
			System.out.println("stack is empty");
		} else {
			stack[top] = 0;
			top--;
		}
	}

	static int peek() {
		return stack[top];
	}

	static void display() {
		if (!isEmpty()) {
			for (int i = 0; i <= top; i++) {
				System.out.print(stack[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		push(4);
		pop();
		push(5);
		push(6);
		display();
	}
}
