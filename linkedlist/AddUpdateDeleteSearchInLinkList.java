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

	static void deleteFirst() {
		head = head.next;
		size--;
	}

	static void deleteLast() {
		Node temp = head;
		Node pre = null;
		while (temp.next != null) {
			pre = temp;
			temp = temp.next;
		}
		pre.next = null;
		size--;
	}

	static void deleteByValue(int value) {
		Node temp = head;
		Node pre = null;
		while (temp.value != value && temp.next != null) {
			pre = temp;
			temp = temp.next;
		}
		if (temp.value == value) {
			Node n = temp.next;
			pre.next = n;
			size--;
		}
	}

	static void deleteByPos(int pos) {
		if (size > pos) {
			if (pos == 0)
				deleteFirst();
			if (pos == size - 1)
				deleteLast();
			Node temp = head;
			Node pre = null;
			while (pos > 0 && temp.next != null) {
				pre = temp;
				temp = temp.next;
				pos--;
			}
			Node n = temp.next;
			pre.next = n;
			size--;
		} else {
			System.out.println("index out of bound");
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

	static int findByValue(int value) {
		Node temp = head;
		while (temp.next != null) {
			if (temp.value == value)
				return 1;
			temp = temp.next;
		}
		return -1;
	}

	static int findByPos(int pos) {
		if (size > pos) {
			if (size - 1 == pos)
				return last.value;
			Node temp = head;
			while (pos > 0) {
				temp = temp.next;
				pos--;
			}
			return temp.value;
		}
		return -1;
	}

	static int findSizeOfLinkedList() {
		if (head == null)
			return 0;
		int count = 1;
		Node temp = head;
		while (temp.next != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	static int findSizeOfLinkedListRec(Node node) {
		if (node == null)
			return 0;
		return 1 + findSizeOfLinkedListRec(node.next);
	}

	public static void main(String[] args) {
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		iterate();
		System.out.println(findSizeOfLinkedList());
		System.out.println(findSizeOfLinkedListRec(head));
	}
}
