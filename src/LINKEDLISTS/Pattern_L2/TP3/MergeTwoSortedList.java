package LINKEDLISTS.Pattern_L2.TP3;

public class MergeTwoSortedList {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {

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
