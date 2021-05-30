package LINKEDLISTS.Pattern_L2.TP2;

import LINKEDLISTS.Pattern_L1.PalindromeLLRec;

public class DeleteDuplicates {

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
