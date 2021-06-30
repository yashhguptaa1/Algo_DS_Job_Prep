package LINKEDLISTS.L2_TwoPointers.Prev_Curr;

public class RemoveNthNodeFromEnd {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        //s1
        ListNode curr=head;
        ListNode prev=null;

        //For n=1 we can lose head node
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        prev=dummyHead;

        //q1:According to Constraints given n will always be valid
        //q2:Follow up: Could you do this in one pass?

        while(curr!=null)
        {
            //s2: Place curr at nth from head
            if(n-- > 0)
                curr=curr.next;

                //s3: get to node just before nth node
            else{
                prev=prev.next;
                curr=curr.next;
            }
        }

        //s4 delete nth node
        prev.next=prev.next.next;

        return dummyHead.next;
    }
}
