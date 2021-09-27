package LINKEDLISTS.Pattern_L3;

public class ReverseLLbetweenMN {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left==right)
            return head;

        //FROM POSSIBLE EDGE CASE 2
        ListNode dummyHeadNode=new ListNode(-1);
        dummyHeadNode.next=head;
        ListNode prevEnd=dummyHeadNode;
        ListNode endRev=head;

        //FROM PATTERN L2.TP2 setting up pointers at optimal position
        for(int i=1;i<left;i++)
        {
            prevEnd=endRev;
            endRev=endRev.next;
        }

        ListNode startRev=endRev;
        ListNode afterStart=startRev.next;

        for(int i=left;i<right;i++)
        {
            startRev=startRev.next;
            afterStart=startRev.next;
        }

        //FROM PATTERN L2.TP3 reverse a LL iteratively
        ListNode prev=prevEnd;
        ListNode curr=endRev;

        while(curr!=afterStart)
        {
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        endRev.next=afterStart;

        prevEnd.next=startRev;

        return dummyHeadNode.next;

    }
}
