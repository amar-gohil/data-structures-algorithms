package linkedlist;

import java.util.HashSet;

public class IntersectionPointOfTwoLinkedLists {
	Node list1;
	Node list2;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static Node getIntersectionPointMethod1(Node list1, Node list2) {
		Node tempL1 = list1;
		Node tempL2 = list2;
		while (tempL1 != null) {
			while (tempL2 != null) {
				if (tempL1.data == tempL2.data)
					return tempL1;
				tempL2 = tempL2.next;
			}
			if (tempL2 == null)
				tempL2 = list2;
			tempL1 = tempL1.next;
		}
		return null;
	}

	static Node getIntersectionPointMethod2(Node list1, Node list2) {
		int c1 = getCount(list1);
		int c2 = getCount(list2);
		if (c1 > c2) {
			return getIntesectionNode(c1 - c2, list1, list2);
		}
		return getIntesectionNode(c2 - c1, list2, list1);
	}

	static Node getIntesectionNode(int d, Node l1, Node l2) {
		Node c1 = l1;
		Node c2 = l2;
		for (int i = 0; i < d; i++) {
			if (c1 == null)
				return null;
			c1 = c1.next;
		}
		while (c1 != null && c2 != null) {
			if (c1.data == c2.data)
				return c1;
			c1 = c1.next;
			c2 = c2.next;
		}
		return null;
	}

	static int getCount(Node node) {
		Node cNode = node;
		int count = 0;
		while (cNode != null) {
			count++;
			cNode = cNode.next;
		}
		return count;
	}

	// list.list2.next = list.list1.next.next.next; for 15 list2 assign list one
	// node
	static Node getIntersectionPointMethod3(Node list1, Node list2) {
		Node temp1 = list1;
		while (temp1.next != null) {
			temp1 = temp1.next;
		}
		temp1.next = list1;

		Node slow = list2;
		Node fast = list2;
		while (slow.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		return slow.next;
	}

	// with HashSet
	static Node getIntersectionPointMethod4(Node list1, Node list2) {
		HashSet<Integer> set = new HashSet<Integer>();
		while (list1 != null) {
			set.add(list1.data);
			list1 = list1.next;
		}
		while (list2 != null) {
			if (set.contains(list2.data))
				return list2;
			list2 = list2.next;
		}
		return null;
	}

	// 2-pointer technique
	static Node getIntersectionPointMethod5(Node list1, Node list2) {
		if (list1 == null || list2 == null)
			return null;
		Node l1 = list1;
		Node l2 = list2;
		while (l1 != null && l2 != null) {
			if (l1 == l2)
				return l1;
			l1 = l1.next;
			l2 = l2.next;
			if (l1 == null)
				l1 = list2;
			if (l2 == null)
				l2 = list1;
		}
		return null;
	}

	public static void main(String[] args) {
		IntersectionPointOfTwoLinkedLists list = new IntersectionPointOfTwoLinkedLists();
		list.list1 = new Node(3);
		list.list1.next = new Node(6);
		list.list1.next.next = new Node(9);
		list.list1.next.next.next = new Node(15);
		list.list1.next.next.next.next = new Node(30);

		list.list2 = new Node(10);
		list.list2.next = list.list1.next.next.next;
		System.out.println(getIntersectionPointMethod5(list.list1, list.list2).data);
	}
}
