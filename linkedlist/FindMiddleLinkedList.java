package linkedlist;

public class FindMiddleLinkedList {
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

	static int findMiddleWithTwoPointer() {
		if (head != null) {
			Node slow = head;
			Node fast = head;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow.value;
		}
		return -1;
	}

	static int findMiddleWithOddNumber() {
		if (head != null) {
			Node temp = head;
			Node mid = head;
			int count = 0;
			while (temp != null) {
				if (count % 2 != 0)
					mid = mid.next;
				++count;
				temp = temp.next;
			}
			return mid.value;
		}
		return -1;
	}

	static int findMiddleWithSize() {
		if (head != null) {
			Node temp = head;
			int mid = size / 2;
			while (mid > 0) {
				mid--;
				temp = temp.next;
			}
			return temp.value;
		}
		return -1;
	}

	public static void main(String[] args) {
		add(1);
		add(2);
		add(3);
		add(4);
		add(5);
		add(6);
		add(7);
		iterate();
		System.out.println();
		System.out.println(findMiddleWithSize());
	}
}
