package queue;

public class QueueUsingStack {

	static int[] one = new int[5];
	static int[] two = new int[5];
	static int top = -1;
	static int top2 = -1;

	static void push1(int value) {
		if (top == one.length - 1) {
			System.out.println("stack overflow");
		} else {
			top++;
			one[top] = value;
		}
	}

	static void push2(int value) {
		if (top2 == two.length - 1) {
			System.out.println("stack overflow");
		} else {
			top2++;
			two[top2] = value;
		}
	}

	static void enqueue(int value) {
		push1(value);
	}

	static void dequeue() {
		for (int i = top; i > 0; i--) {
			push2(one[i]);
			one[i] = 0;
		}
		top = -1;
		for (int i = top2; i > -1; i--) {
			push1(two[i]);
		}
		top2 = -1;
	}

	static void display() {
		for (int i = 0; i <= top; i++) {
			System.out.print(one[i] + " ");
		}
	}

	public static void main(String[] args) {
		enqueue(1);
		enqueue(2);
		enqueue(3);
		enqueue(4);
		dequeue();
		enqueue(5);
		enqueue(6);
		dequeue();
		display();
	}
}
