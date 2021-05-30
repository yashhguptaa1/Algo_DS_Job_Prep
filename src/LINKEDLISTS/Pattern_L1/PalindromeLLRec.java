package LINKEDLISTS.Pattern_L1;

import LINKEDLISTS.Pattern_L4.PalindromeLinkedList;

public class PalindromeLLRec {
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
