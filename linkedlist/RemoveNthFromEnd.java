package com.datastructure.linkedlist;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;

    }
    public static void display(ListNode node){
        ListNode head = node;
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode = RemoveNthFromEnd.removeNthFromEnd(listNode,2);
        display(listNode);
    }
}
