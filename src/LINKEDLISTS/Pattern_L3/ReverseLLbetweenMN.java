package LINKEDLISTS.Pattern_L3;

import LINKEDLISTS.Pattern_L2.TP1.TestForListCycles;

public class ReverseLLbetweenMN {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode reverseBetween(ListNode h, int b, int c) {

        if(b==c)
            return h;

        //FROM POSSIBLE EDGE CASE 2
        ListNode dummyHeadNode=new ListNode(-1);
        dummyHeadNode.next=h;
        ListNode prevEnd=dummyHeadNode;
        ListNode endRev=h;

        //FROM PATTERN L2.TP2 setting up pointers at optimal position
        for(int i=1;i<b;i++)
        {
            prevEnd=endRev;
            endRev=endRev.next;
        }

        ListNode startRev=endRev;
        ListNode afterStart=startRev.next;

        for(int i=b;i<c;i++)
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
