package linkedlist;

public class AddUpdateDeleteSearchInLinkList {

	static Node head;
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
		Node node = new Node(value, null);
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
		size++;
	}

	static void addAtFirst(int value) {
		Node node = new Node(value, null);
		if (head == null) {
			head = node;
		} else {
			node.next = head;
		}
		head = node;
		size++;
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
	}
}
