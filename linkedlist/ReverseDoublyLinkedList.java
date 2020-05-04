package linkedlist;

public class ReverseDoublyLinkedList {
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

	static void iterateWithPrev() {
		if (head == null) {
			return;
		} else {
			Node temp = last;
			while (temp != null) {
				System.out.print(temp.value + " ");
				temp = temp.prev;
			}
		}
	}

	static void reverseLinkedList() {
		if (head != null) {
			last = head;
			Node current = head;
			Node nextNode = current.next;
			
			while (nextNode != null) {
				nextNode = nextNode.next;
				current.next = current.prev;
				current.prev = nextNode;
				current = nextNode;
			}
			head = current;
		}
	}

	static void reverseLinkedListRec(Node prev, Node nextNode, Node current) {
		if (nextNode == null) {
			head = prev;
			return;
		}
		nextNode = nextNode.next;
		current.next = prev;
		current.prev = nextNode;
		prev = current;
		current = nextNode;
		reverseLinkedListRec(prev, nextNode, current);

	}

	static void reverseLinkedListRecStart() {
		last = head;
		reverseLinkedListRec(null, head, head);
	}

	public static void main(String[] args) {
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		iterate();
		System.out.println();
		iterateWithPrev();
		System.out.println();
		reverseLinkedListRecStart();
		iterate();
		System.out.println();
		iterateWithPrev();
	}
}
