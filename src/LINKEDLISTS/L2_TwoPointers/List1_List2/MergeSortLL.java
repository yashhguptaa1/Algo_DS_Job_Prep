package LINKEDLISTS.L2_TwoPointers.List1_List2;

import LINKEDLISTS.Pattern_L4.E_FOLD_ReorderLL;

public class MergeSortLL {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode mid = middleNode(head);
        ListNode nHead= mid.next;
        mid.next=null;

        ListNode l1=sortList(head);
        ListNode l2=sortList(nHead);

        return mergeTwoLists(l1,l2);
    }

    public ListNode middleNode(ListNode head) {

        //For 0 sized list and 1 sized list
        if(head == null || head.next == null)
            return head;

        ListNode slow =head;
        ListNode fast=head.next;

        //For ODD sized list : check fast.next!=null
        //For EVEN sized list : check fast!=null
        while(fast!= null && fast.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;

    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {

        //Handling three cases here
        //both empty
        //either list1 empty
        //or list2 empty
        if(a==null || b==null)
            return a!=null ? a : b;

        ListNode t1=a;
        ListNode t2=b;

        ListNode dummyHeadNode=new ListNode(-1);
        ListNode mergedListItr=dummyHeadNode;

        while(t1 != null && t2!=null)
        {
            if(t1.val <= t2.val)
            {
                mergedListItr.next=t1;
                t1=t1.next;
            }

            else
            {
                mergedListItr.next=t2;
                t2=t2.next;
            }

            mergedListItr=mergedListItr.next;
        }

        while(t1 != null)
        {
            mergedListItr.next=t1;
            t1=t1.next;
            mergedListItr=mergedListItr.next;
        }

        while(t2!=null)
        {
            mergedListItr.next=t2;
            t2=t2.next;
            mergedListItr=mergedListItr.next;
        }

        return dummyHeadNode.next;

    }
}
