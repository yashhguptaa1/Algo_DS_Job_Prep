package LINKEDLISTS.Pattern_L4;

import LINKEDLISTS.Pattern_L2.TP2.RotateList;

public class ReorderLL {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode reorderList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null)
        {
            return head;
        }

        ListNode mid = getMid(head);

        ListNode head1 = head;

        ListNode head2 = mid.next;

        mid.next=null;

        head2 =reverseList(head2);

        ListNode t1=head1;
        ListNode t2=head2;

        //Concept used in Pattern L2.TP3
        while(t1 !=null && t2 !=null)
        {
            ListNode nextt1=t1.next;
            ListNode nextt2=t2.next;

            t1.next=t2;
            t1=nextt1;

            t2.next=nextt1;
            t2=nextt2;
        }

        return head;

    }

    //Ques: Find Middle Node Second Version from Pattern_L2.TP1
    public ListNode getMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;

    }
    //Ques: Reverse the given LL from Pattern_L1
    public ListNode reverseList(ListNode A) {

        //Edge Case || Base Case
        if(A==null || A.next == null)
        {//Note we cannot return NULL here as when code hit base case
            //the reference to last node of orig list is returned and stored in variable
            //headReversedLL
            return A;
        }


        ListNode headReversedLL=reverseList(A.next);

        A.next.next=A;
        A.next=null;

        return headReversedLL;

    }

}
