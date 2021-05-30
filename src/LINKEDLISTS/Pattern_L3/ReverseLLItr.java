package LINKEDLISTS.Pattern_L3;

import LINKEDLISTS.Pattern_L1.ReverseLL;

public class ReverseLLItr {

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

        return justBeforeCurr;
    }
}
