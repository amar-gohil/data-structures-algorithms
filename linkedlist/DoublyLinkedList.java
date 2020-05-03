package linkedlist;

public class DoublyLinkedList {

	static Node head = null;
	static Node last = null;
	static int size = 0;

	static class Node {
		Node prev;
		int value;
		Node next;

		Node(int value) {
			prev = null;
			this.value = value;
			next = null;
		}
	}

	static void add(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			last = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp;
			last = newNode;
		}
		size++;
	}

	static void addAtFrist(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			last = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}

	static void addAtLast(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
		}
		size++;
	}

	static void addAtPos(int value, int pos) {
		if (size >= pos) {
			if (pos == 0)
				addAtFrist(value);
			else if (pos == size)
				addAtLast(value);
			else {
				Node newNode = new Node(value);
				Node temp = head;
				while (pos > 1) {
					pos--;
					temp = temp.next;
				}
				newNode.prev = temp;
				newNode.next = temp.next;
				temp.next = newNode;
				temp.next.prev = newNode;
			}
			size++;
		} else {
			System.out.println("index out of bound");
		}
	}

	static void addAfterPos(int value, int pos) {
		if (size > pos) {
			if (pos == size - 1)
				addAtLast(value);
			else {
				Node newNode = new Node(value);
				Node temp = head;
				while (pos > 0) {
					pos--;
					temp = temp.next;
				}
				newNode.prev = temp;
				newNode.next = temp.next;
				temp.next = newNode;
				temp.next.prev = newNode;
			}
			size++;
		} else {
			System.out.println("index out of bound");
		}
	}

	static void deleteFrist() {
		if (head == null) {
			System.out.println("Nothing to delete");
		} else {
			Node temp = head;
			head = head.next;
			head.prev = null;
			temp.next = null;
			size--;
		}
	}

	static void deleteLast() {
		if (head == null) {
			System.out.println("Nothing to delete");
		} else {
			Node temp = last;
			last = last.prev;
			last.next = null;
			temp.prev = null;
			size--;
		}
	}

	@SuppressWarnings("unused")
	static void deleteAtPos(int pos) {
		if (pos < size) {
			if (pos == 0)
				deleteFrist();
			else if (pos == size - 1) {
				deleteLast();
			} else {
				Node temp = head;
				while (pos > 1) {
					pos--;
					temp = temp.next;
				}
				Node delete = temp.next;
				temp.next = temp.next.next;
				temp.next.prev = temp.next;
				delete = null;
				size--;
			}
		} else {
			System.out.println("index out of bound");
		}
	}

	@SuppressWarnings("unused")
	static void deleteByValue(int value) {
		if (head == null) {
			System.out.println("LinkedList id null");
		} else if (head.value == value) {
			deleteFrist();
		} else if (last.value == value) {
			deleteLast();
		} else {
			Node temp = head;
			while (temp.value != value && temp.next != null) {
				temp = temp.next;
			}
			if (temp.next == null) {
				System.out.println("Value notfound");
			}
			if (temp.value == value) {
				Node delete = temp;
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				delete = null;
				size--;
			}
		}
	}

	static void iterate() {
		if (head == null) {
			return;
		} else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.value + " ");
				temp = temp.next;
			}
		}
	}

	public static void main(String[] args) {
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		deleteByValue(6);
		iterate();
	}
}
