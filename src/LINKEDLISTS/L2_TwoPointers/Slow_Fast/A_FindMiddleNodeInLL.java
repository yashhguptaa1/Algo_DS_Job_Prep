package LINKEDLISTS.L2_TwoPointers.Slow_Fast;

// TC for all CODES
//O(n)  and not O(n/2)
public class A_FindMiddleNodeInLL {

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
        //For 0 sized list and 1 sized list
        if(head == null || head.next == null)
            return head;

        ListNode slow =head;
        ListNode fast=head;

        //For ODD sized list : check fast.next!=null
        //For EVEN sized list : check fast!=null
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
