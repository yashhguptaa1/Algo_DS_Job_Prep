package LINKEDLISTS.Pattern_L2.TP2;

public class RemoveNthNodeFromEnd {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode removeNthFromEnd(ListNode head, int B) {

        if(head == null)
            return head;

        ListNode dummyHeadNode=new ListNode(-1);
        ListNode left=dummyHeadNode;
        dummyHeadNode.next=head;
        ListNode right=head;

        while( B > 0 && right!=null)
        {
            right=right.next;
            B--;
        }

        if( B >= 0 && right == null)
        {
            //we got invalid B
            //delete head node
            dummyHeadNode.next=head.next;

        }

        else{
            while(right!=null)
            {
                left=left.next;
                right=right.next;

            }

            left.next=left.next.next;
        }

        return dummyHeadNode.next;
    }

}
