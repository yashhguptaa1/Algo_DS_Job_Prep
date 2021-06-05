package LINKEDLISTS.Pattern_L2.TP1;

import LINKEDLISTS.Pattern_L4.PalindromeLinkedList;

public class FindMiddleNodeInLL {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    // if we compare both the codes below
    //the resultant nodes returned from both function have a difference of one
    //to obtain this difference start second pointer one node ahead of first pointer


    public ListNode getMidFirstNodeSecondHalf(ListNode head)
    {
        ListNode slow =head;
        ListNode fast=head;

        while(fast!= null && fast.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
    public ListNode getMidEndofFirstHalf(ListNode head)
    {
        ListNode slow=head;
        ListNode fast =head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }


}
