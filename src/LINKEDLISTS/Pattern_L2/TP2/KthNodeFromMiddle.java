package LINKEDLISTS.Pattern_L2.TP2;

import LINKEDLISTS.Pattern_L2.TP1.TestForListCycles;

public class KthNodeFromMiddle {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public int solve(ListNode head, int K) {

        if(head == null)
            return -1;

        ListNode left=head;
        ListNode right=head;
        ListNode middleNode=getMidFNSH(head);

        //System.out.println(middleNode.val);

        while(  K > 0 && right != middleNode)
        {
            right=right.next;
             K--;
        }

        //System.out.println("  K" + K);
        //System.out.println(right.val);

        //3 possible cases that arise
        //B is still greater than 0 even though right ptr is on middle node
        //B is 0 but right is not pointing to middle node
        //B is 0 and right is pointing to middle Node

        if( K > 0)
            return -1;

            // else if( K == 0 && right == middleNode)
            // {
            //     left=left.next;
            // }

        else
        {
            while( right != middleNode)
            {
                left=left.next;
                right=right.next;

            }
        }


        return left.val;
    }

    public ListNode getMidFNSH(ListNode start)
    {
        ListNode slow =start;
        ListNode fast=start;

        while(fast!= null && fast.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    // Kth Node from Last

    public int kthFromLast(ListNode head,int k){
        // write your code here

        ListNode leftOfWindow = head;
        ListNode rightOfWindow = head;


        //considering 0 based indexing
        // if k=3
        //rightOfWindow will point to 4th node from start
        // and as LeftWindow points to start
        //thus there is adifference of k nodes between left and right
        for (int i = 0; i < k; i++) {
            rightOfWindow = rightOfWindow.next;
        }

        // Since k=0 is a valid input and it means we want the last node
        //we make our loop run to .next != null
        //instead of rightOfWindow!=null
        while (rightOfWindow.next != null) {
            leftOfWindow = leftOfWindow.next;
            rightOfWindow = rightOfWindow.next;
        }


        return leftOfWindow.val;
    }
}
