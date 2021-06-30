package LINKEDLISTS.Pattern_L1;

public class D_PalindromeLLRec {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    ListNode globalRefNodeFromLeft;

    public int lPalin(ListNode h) {

        globalRefNodeFromLeft=h;

        boolean ans = isPali(h);

        return ans?1:0;
    }

    public boolean isPali(ListNode NodeFromRight)
    {
        if(NodeFromRight == null)
            return true;

        boolean ansSoFarFromRecursiveCalls=isPali(NodeFromRight.next);

        boolean MyWork_isEqual = (globalRefNodeFromLeft.val == NodeFromRight.val)?true:false;

        globalRefNodeFromLeft=globalRefNodeFromLeft.next;

        return ansSoFarFromRecursiveCalls && MyWork_isEqual;
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