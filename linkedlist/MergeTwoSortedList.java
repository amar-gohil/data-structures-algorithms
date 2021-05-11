package com.datastructure.linkedlist;

public class MergeTwoSortedList {


 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(100);
        ListNode last = fake;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                last.next =l1;
                last = l1;
                l1 = l1.next;
            }else{
                last.next =l2;
                last = l2;
                l2 = l2.next;
            }
        }
        if(l1 != null) last.next = l1;
        if(l2 != null) last.next = l2;
        return fake.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode ln1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode ln2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode result = mergeTwoSortedList.mergeTwoLists(ln1,ln2);
        while (result != null){
            System.out.print(result.val + " | ");
            result = result.next;
        }
    }
}
