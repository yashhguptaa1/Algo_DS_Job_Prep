package LINKEDLISTS.L2_TwoPointers.Prev_Curr;

public class RotateList {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode rotateRight(ListNode h, int k) {

        //Find the tail and size of LL
        ListNode tail=h;
        //first node already counted
        int size=1;

        while(tail.next!=null)
        {
            tail=tail.next;
            size++;
        }

        if(k>=size)
            k=k%size;

        int left=size-k;

        ListNode curr=h;
        int i=1;

        //Reach the breakpoint after which elements will be rotated
        while(curr!=null && i<left)
        {
            curr=curr.next;
            i++;
        }

        //Connect last node of LL to first Node to form cycle
        tail.next=h;

        //Place head of LL to the node just after breakpoint
        h=curr.next;

        //Break the LL from breakpoint
        //it means our breakpoint will act as tail node of new LL
        curr.next=null;
        //System.out.println(size);

        return h;
    }
}
