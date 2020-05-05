package linkedlist;

public class CircularLinkedList {

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

	static void addAtFirst(int value) {
		Node node = new Node(value);
		if (last == null) {
			last = node;
			last.next = last;
		} else {
			node.next = last.next;
			last.next = node;
		}
		size++;
	}

	static void addAtPos(int pos, int value) {
		if (pos <= size) {
			if (pos == 1)
				addAtFirst(value);
			else if (pos == size) {
				add(value);
			} else {
				Node node = new Node(value);
				Node temp = last.next;
				while (pos > 1) {
					temp = temp.next;
					pos--;
				}
				Node next = temp.next;
				temp.next = node;
				temp.next.next = next;
				size++;
			}
		} else {
			System.out.println("index out of bound");
		}
	}

	static void deleteAtFirst() {
		if (last != null) {
			if (last == last.next)
				last = null;
			else {
				Node head = last.next;
				last.next = head.next;
				head = null;
			}
			size--;
		}
	}

	static void deleteAtLast() {
		if (last != null) {
			if (last == last.next)
				last = null;
			else {
				Node head = last.next;
				while (head.next != last) {
					head = head.next;
				}
				Node temp = last;
				last = head;
				last.next = temp.next;
				temp = null;
				head = null;
			}
			size--;
		}
	}

	static void deleteAtPos(int pos) {
		if (pos < size) {
			if (pos == 0)
				deleteAtFirst();
			else if (pos == size - 1)
				deleteAtLast();
			else {
				Node head = last.next;
				while (pos > 1) {
					head = head.next;
					pos--;
				}
				Node temp = head.next;
				head.next = temp.next;
				temp = null;
				size--;
			}
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
		System.out.println();
		deleteAtPos(2);
		iterate();
	}
}
