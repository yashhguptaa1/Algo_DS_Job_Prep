package LINKEDLISTS.Pattern_L4;

import LINKEDLISTS.Pattern_L1.ReverseLL;


public class C_PalindromeLinkedList {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    // TC : O(5n/2) = O(n)
    public boolean isPalindrome(ListNode head) {

        //For 0 sized list and 1 sized list
        if(head == null || head.next == null)
            return true;

        //Break the given LL into two from middle
        ListNode middleNode=getMidEndofFirstHalf(head);  // TC - > O(n)
        ListNode head2=middleNode.next;
        middleNode.next=null;

        //Reverse the second half of LL obtained after breaking
        head2=revLL(head2);// TC - > O(n/2)

        //Set pointers on both the list
        ListNode t1=head;
        ListNode t2=head2;

        //Concept used in Pattern LINKEDLISTS.L2_TwoPointers.List1_List2;
        // now check if value are same in both lists
        //for odd list one extra node is there which not needed to be checked
        while(t1 !=null && t2 != null)// TC - > O(n/2)
        {
            if(t1.val != t2.val)
                return false;

            t1=t1.next;
            t2=t2.next;
        }

        head2=revLL(head2);// TC - > O(n/2)
        middleNode.next=head2;
        return true;
    }

    //LINKEDLISTS.L2_TwoPointers.Prev_Curr.B_ReverseLLIterative
    public ListNode revLL(ListNode head)
    {
        //For 0 sized list and 1 sized list
        if(head == null || head.next == null)
            return head;

        ListNode curr=head;
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

    //LINKEDLISTS.L2_TwoPointers.Slow_Fast.A_FindMiddleNodeInLL
    public ListNode getMidEndofFirstHalf(ListNode head)
    {
        //For 0 sized list and 1 sized list
        if(head == null || head.next == null)
            return head;

        ListNode slow=head;
        ListNode fast =head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

}
/*
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:

Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.
 */