package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class FindLoopInList {
	static Node head;

	static class Node {
		Node next;
		int data;

		Node(int value, Node node) {
			this.next = node;
			this.data = value;
		}
	};

	static boolean isLoopInList(Node node) {
		Node slow = node;
		Node fast = node;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	static Node findLoopNode(Node node) {
		{
			Node slow = node;
			Node fast = node;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if (slow == fast) {
					Node head = node;
					Node k = fast;
					while (head != k) {
						head = head.next;
						k = k.next;
					}
					return k;
				}
			}
			return null;
		}
	}

	static void findLoopWithMap(Node node) {
		Map<Node, Integer> map = new HashMap<Node, Integer>();
		Node temp = node;
		while (temp.next != null && !map.containsKey(temp)) {
			map.put(temp, 1);
			temp = temp.next;
		}
		System.out.println("findLoopWithMap = " + temp.data);
		return;
	}

	public static void main(String[] args) {
		Node node7 = new Node(7, null);
		Node node6 = new Node(6, node7);
		Node node5 = new Node(5, node6);
		Node node4 = new Node(4, node5);
		Node node3 = new Node(3, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);
		node7.next = node4;
		System.out.print(node1.data + " ");
		System.out.print(node1.next.data + " ");
		System.out.print(node1.next.next.data + " ");
		System.out.print(node1.next.next.next.data + " ");
		System.out.print(node1.next.next.next.next.data + " ");
		System.out.print(node1.next.next.next.next.next.data + " ");
		System.out.print(node1.next.next.next.next.next.next.data + " ");
		System.out.println(node1.next.next.next.next.next.next.next.data + " ");
		System.out.println(isLoopInList(node1));
		System.out.println(findLoopNode(node1).data);
		findLoopWithMap(node1);
	}
}
