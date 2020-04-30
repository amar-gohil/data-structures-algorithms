package linkedlist;

public class AddUpdateDeleteSearchInLinkList {

	static Node head;
	static Node last;
	static int size;

	static class Node {
		int value;
		Node next;

		Node(int value, Node node) {
			this.next = null;
			this.value = value;
		}
	}

	static void add(int value) {
		Node newNode = new Node(value, null);
		if (head == null) {
			head = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	static void addAtFirst(int value) {
		Node newNode = new Node(value, null);
		if (head == null) {
			head = newNode;
			last = newNode;
		} else {
			newNode.next = head;
		}
		head = newNode;
		size++;
	}

	static void deleteFirst() {
		head = head.next;
	}

	static void deleteLast() {
		Node temp = head;
		Node pre = null;
		while (temp.next != null) {
			pre = temp;
			temp = temp.next;
		}
		pre.next = null;
	}
	
	static void addAtPos(int pos, int value) {
		if (pos > size) {
			System.out.println("index out of bound");
		} else if (pos == 0) {
			addAtFirst(value);
		} else if (size == pos) {
			add(value);
		} else {
			Node node = new Node(value, null);
			Node temp = head;
			while (pos > 1) {
				temp = temp.next;
				pos--;
			}
			Node next = temp.next;
			temp.next = node;
			temp.next.next = next;
			size++;
		}
	}

	static void iterate() {
		if (head != null) {
			Node temp = head;
			while (temp.next != null) {
				System.out.print(temp.value + " ");
				temp = temp.next;
			}
			System.out.print(temp.value + " ");
		}
	}

	public static void main(String[] args) {
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		iterate();
		addAtFirst(0);
		System.out.println();
		iterate();
		addAtPos(3, 11);
		System.out.println();
		iterate();
		deleteFirst();
		System.out.println();
		deleteLast();
		iterate();
	}
}
