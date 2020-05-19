package queue;

public class CircularQueueUsingLinkedList {
	static Node first = null;
	static Node last = null;

	static class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

	static void enqueue(int value) {
		Node node = new Node(value);
		if (first == null) {
			first = node;
			node.next = first;
			last = first;
		} else {
			node.next = last.next;
			last.next = node;
			last = node;
		}
	}

	static void dequeue() {
		if (first == null && last == null) {
			System.out.println("Queue is empty");
		} else if (first == last) {
			first = last = null;
		} else {
			first = first.next;
			last.next = first;
		}
	}

	static void display() {
		if (first != null) {
			Node temp = first;
			while (temp != last) {
				System.out.print(temp.value + " ");
				temp = temp.next;
			}
			System.out.print(temp.value + " ");
		}
	}

	static void peek() {
		if (first != null) {
			System.out.println(first.value);
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
		display();
	}
}
