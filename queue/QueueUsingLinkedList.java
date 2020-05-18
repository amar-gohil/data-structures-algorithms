package queue;

public class QueueUsingLinkedList {

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
		if (first == null && last == null) {
			Node node = new Node(value);
			first = last = node;
		} else {
			Node node = new Node(value);
			last.next = node;
			last = node;
		}
	}

	static void dequeue() {
		if (first == null && last == null) {
			System.out.println("queue is empty");
		} else if (first == last) {
			first = last = null;
		} else {
			Node node = first;
			first = node.next;
			node = null;
		}
	}

	static void peek() {
		if (first != null) {
			System.out.println(first.value);
		}
	}

	static void display() {
		if (first != null) {
			Node temp = first;
			while (temp != null) {
				System.out.print(temp.value + " ");
				temp = temp.next;
			}
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
