package linkedlist;

import java.util.LinkedList;
import java.util.Stack;

public class FindNFromLastWithStack {
	public static void main(String[] args) {
		LinkedList<Integer> lList = new LinkedList<>();
		lList.add(1);
		lList.add(2);
		lList.add(3);
		lList.add(4);
		lList.add(5);
		lList.add(6);
		Stack<Integer> stack = new Stack<Integer>();
		for (Integer integer : lList) {
			stack.push(integer);
		}
		int p = 2;
		while (p > 0) {
			stack.pop();
			p--;
		}
		System.out.println(stack.pop());
	}
}
