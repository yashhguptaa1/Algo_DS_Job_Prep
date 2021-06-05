package LINKEDLISTS.Pattern_L2.TP3;

public class Sort01_EvenOdd {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    //QUESTION : Sort Binary Linked List on INTERVIEWBIT

    //USING SPACE
    //SAME CONCEPT CAN BE USED IN EVEN ODD
    public ListNode solve(ListNode head) {

        ListNode sorted0=new ListNode(-1);
        ListNode track0=sorted0;

        ListNode sorted1=new ListNode(-2);
        ListNode track1=sorted1;


        // iterator -> help in movement
        ListNode itr=head;

        while (itr!=null)
        {
            if(itr.val == 0)
            {
                track0.next=itr;
                track0=track0.next;
            }
            else
            {
                track1.next=itr;
                track1=track1.next;
            }
            itr=itr.next;
        }
    // 0 -> 1\

        track0.next=sorted1.next;
        track1.next=null;

        return sorted0.next;

    }
}
