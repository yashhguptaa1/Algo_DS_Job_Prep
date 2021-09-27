package LINKEDLISTS.L2_TwoPointers.List1_List2;

public class Sort01_EvenOdd {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    //QUESTION : Sort Binary Linked List on INTERVIEWBIT

    //USING SPACE
    //SAME CONCEPT CAN BE USED TO SEPERATE EVEN NUMBERS and then ODD NUMBERS
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
/*
Example Input
Input 1:

 1 -> 0 -> 0 -> 1
Input 2:

 0 -> 0 -> 1 -> 1 -> 0


Example Output
Output 1:

 0 -> 0 -> 1 -> 1
Output 2:

 0 -> 0 -> 0 -> 1 -> 1
 */