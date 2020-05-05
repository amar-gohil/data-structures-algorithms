package linkedlist;

public class ReverseCircularLinkedList {
	static Node last;
	static int size = 0;

	static class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
			next = null;
		}
	}

	static void add(int value) {
		Node newNode = new Node(value);
		if (last == null) {
			last = newNode;
			last.next = last;
		} else {
			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	static void reverse() {
		if (last != null) {
			Node prev;
			Node current = last.next;
			Node nextNode = current.next;
			while (current != last) {
				prev = current;
				current = nextNode;
				nextNode = current.next;
				current.next = prev;
			}
			nextNode.next = last;
			last = nextNode;
		}
	}

	static void iterate() {
		if (last != null) {
			Node temp = last.next;
			do {
				System.out.print(temp.value + " ");
				temp = temp.next;
			} while (temp != last.next);
		}
	}

	public static void main(String[] args) {
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		iterate();
		reverse();
		System.out.println();
		iterate();
	}
}
