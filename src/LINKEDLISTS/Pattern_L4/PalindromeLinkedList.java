package LINKEDLISTS.Pattern_L4;

import LINKEDLISTS.Pattern_L1.ReverseLL;

public class PalindromeLinkedList {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }


    public int lPalin(ListNode head) {

        ListNode middleNode=getMidEndofFirstHalf(head);

        ListNode head2=middleNode.next;
        middleNode.next=null;
        head2=revLL(head2);

        ListNode t1=head;
        ListNode t2=head2;

        //Concept used in Pattern L2.TP3
        while(t1 !=null && t2 != null)
        {
            if(t1.val != t2.val)
                return 0;

            t1=t1.next;
            t2=t2.next;
        }

        return 1;

    }

    //Ques: Reverse the given LL from Pattern_L1
    public ListNode revLL(ListNode h)
    {
        ListNode curr=h;
        ListNode prev=null;

        while(curr!=null)
        {
            ListNode nextOfCurr=curr.next;

            curr.next=prev;

            prev=curr;

            curr=nextOfCurr;
        }

        return prev;

    }

    //Ques: Find Middle Node Second Version from Pattern_L2.TP1
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
