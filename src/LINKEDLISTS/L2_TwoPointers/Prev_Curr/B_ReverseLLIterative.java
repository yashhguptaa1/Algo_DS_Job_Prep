package LINKEDLISTS.L2_TwoPointers.Prev_Curr;

import LINKEDLISTS.Pattern_L1.ReverseLL;

public class B_ReverseLLIterative {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    //Iterative

    public  ListNode reverseListItr( ListNode head) {

         ListNode curr = head;

         ListNode justBeforeCurr=null;

        while(curr!=null)
        {
            ListNode nextOfCurr=curr.next;

            curr.next=justBeforeCurr;

            justBeforeCurr=curr;

            curr=nextOfCurr;

        }
        //When curr points to null
        // justBeforeCurr will point to tail node
        return justBeforeCurr;
    }


    public ListNode reverseList(ListNode head) {

        //For 0 sized list and 1 sized list
        if(head == null || head.next == null)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode forw = null;

        while (curr != null)
        {
            forw = curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }

        return prev;
    }
}
