package linkedlist;

public class SublistSearch {
	static class Node {
		Node next;
		int data;
	};

	static boolean findList(Node first, Node second) {
		Node ptr1 = first, ptr2 = second;
		if (first == null && second == null)
			return true;
		if (first == null || (first != null && second == null))
			return false;
		while (second != null) {
			ptr2 = second;
			while (ptr1 != null) {
				if (ptr2 == null)
					return false;
				else if (ptr1.data == ptr2.data) {
					ptr1 = ptr1.next;
					ptr2 = ptr2.next;
				} else
					break;
			}
			if (ptr1 == null)
				return true;
			ptr1 = first;
			second = second.next;
		}

		return false;
	}

	static Node newNode(int key) {
		Node temp = new Node();
		temp.data = key;
		temp.next = null;
		return temp;
	}

	// Driver Code
	public static void main(String[] args) {
		/*
		 * Let us create two linked lists to test the above functions. Created
		 * lists shall be a: 1->2->3->4 b: 1->2->1->2->3->4
		 */
		Node a = newNode(1);
		a.next = newNode(2);
		a.next.next = newNode(3);
		a.next.next.next = newNode(4);

		Node b = newNode(1);
		b.next = newNode(2);
		b.next.next = newNode(1);
		b.next.next.next = newNode(2);
		b.next.next.next.next = newNode(3);
		b.next.next.next.next.next = newNode(4);

		if (findList(a, b) == true)
			System.out.println("LIST FOUND");
		else
			System.out.println("LIST NOT FOUND");
	}
}
