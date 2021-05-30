package LINKEDLISTS.Pattern_L2.TP1;

import LINKEDLISTS.Pattern_L4.PalindromeLinkedList;

public class FindMiddleNodeInLL {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode getMidFirstNodeSecondHalf(ListNode start)
    {
        ListNode slow =start;
        ListNode fast=start;

        while(fast!= null && fast.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
    public ListNode getMidEndofFirstHalf(ListNode h)
    {
        ListNode slow=h;
        ListNode fast =h.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
}
