package stack;

public class StackUsingLinkedList {

	static Node top;

	static class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

	static void push(int value) {
		Node node = new Node(value);
		node.next = top;
		top = node;
	}

	static void pop() {
		if (top != null) {
			Node node = top.next;
			top = node;
			node = null;
		} else {
			System.out.println("stack is empty");
		}
	}

	static int peek() {
		if (top != null) {
			return top.value;
		}
		return -1;
	}

	static void display() {
		if (top != null) {
			Node temp = top;
			while (temp != null) {
				System.out.print(temp.value + " ");
				temp = temp.next;
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
