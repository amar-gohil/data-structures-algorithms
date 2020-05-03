package linkedlist;

public class ReverseLinkedList {
	static Node head;
	static int size;

	static class Node {
		int value;
		Node next;

		Node(int value) {
			this.next = null;
			this.value = value;
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

	static void reverseLinkedList() {
		Node prev = null;
		Node current = head, nextNode = head;
		while (nextNode != null) {
			nextNode = nextNode.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		head = prev;
	}

	static void reverseLinkedListRec(Node prev, Node nextNode, Node current) {
		if (nextNode == null) {
			head = prev;
			return;
		}
		nextNode = nextNode.next;
		current.next = prev;
		prev = current;
		current = nextNode;
		reverseLinkedListRec(prev, nextNode, current);

	}

	public static void main(String[] args) {
		ReverseLinkedList.head = new Node(1);
		ReverseLinkedList.head.next = new Node(2);
		ReverseLinkedList.head.next.next = new Node(3);
		ReverseLinkedList.head.next.next.next = new Node(4);
		ReverseLinkedList.head.next.next.next.next = new Node(5);
		iterate();
		System.out.println();
		reverseLinkedListRec(null, head, head);
		iterate();

	}
}
