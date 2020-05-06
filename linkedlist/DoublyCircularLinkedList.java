package linkedlist;

public class DoublyCircularLinkedList {

	static Node head;
	static Node last;
	static int size = 0;

	static class Node {
		Node prev;
		int value;
		Node next;

		Node(int value) {
			this.prev = null;
			this.value = value;
			this.next = null;
		}
	}

	static void add(int value) {
		Node node = new Node(value);
		if (head == null) {
			head = last = node;
			head.next = head;
			head.prev = head;
		} else {
			last.next = node;
			node.prev = last;
			node.next = head;
			head.prev = node;
			last = node;
		}
		size++;
	}

	static void addAtFirst(int value) {
		Node node = new Node(value);
		if (head == null) {
			head = last = node;
			head.next = head;
			head.prev = head;
		} else {
			node.next = head;
			node.prev = last;
			head.prev = node;
			last.next = node;
			head = node;
		}
		size++;
	}

	static void addAtPos(int pos, int value) {
		if (pos > -1 && pos < size) {
			if (pos == 0)
				addAtFirst(value);
			else if (pos == size - 1) {
				add(value);
			} else {
				Node temp = head;
				while (pos > 1) {
					pos--;
					temp = temp.next;
				}
				Node node = new Node(value);
				node.prev = temp;
				node.next = temp.next;
				temp.next.prev = node;
				temp.next = node;
				size++;
			}
		} else {
			System.out.println("index out of bound");
		}
	}

	static void deleteAtFirst() {
		if (head != null) {
			if (head.next == head) {
				head = null;
				last = null;
			} else {
				Node temp = head;
				head.next.prev = last;
				last.next = temp.next;
				head = temp.next;
				temp = null;
			}
			size--;
		}
	}

	static void deleteAtLast() {
		if (head != null) {
			if (head.next == head) {
				head = null;
				last = null;
			} else {
				Node temp = last;
				last.prev.next = head;
				head.prev = temp.prev;
				last = temp.prev;
				temp = null;
			}
			size--;
		}
	}

	static void deleteAtPos(int pos) {
		if (pos > -1 && pos < size) {
			if (pos == 0)
				deleteAtFirst();
			else if (pos == size - 1) {
				deleteAtLast();
			} else {
				Node node = head;
				while (pos > 1) {
					pos--;
					node = node.next;
				}
				Node temp = node;
				node.next = temp.next.next;
				node.next.prev = temp.prev;
				temp = null;
				size--;
			}
		} else {
			System.out.println("index out of bound");
		}
	}

	static void iterate() {
		if (head != null) {
			Node temp = head;
			while (temp.next != last.next) {
				System.out.print(temp.value + " ");
				temp = temp.next;
			}
			System.out.println(temp.value);
		}
	}

	public static void main(String[] args) {
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		System.out.println(last.next.value);
		deleteAtPos(3);
		System.out.println(last.next.value);
		iterate();
	}
}
