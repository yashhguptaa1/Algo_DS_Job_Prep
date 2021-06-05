package LINKEDLISTS.Pattern_L2.TP2;

import LINKEDLISTS.Pattern_L1.PalindromeLLRec;

public class RemoveDuplicatesFromSortedList {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode temp = head;
        ListNode itr = head.next;

        while(itr != null)
        {

            if(temp.val != itr.val)
            {
                temp.next = itr;
                temp=temp.next;
            }

            itr=itr.next;
        }
        //if our last node was also part of duplicate sequence
        temp.next=itr;

        return head;
    }
}

/*
second solution

USING ONLY SINGLE POINTER

 // Compare this solution with Remove duplicates II
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode p = head;

        //here our p pointer points to first node of duplicate sublist
        //We keep on deleting nodes after this first node by changing
        //.next of first node of duplicate sublist

        while( p!= null && p.next != null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }

        return head;
    }
}
 */
