package LINKEDLISTS.L2_TwoPointers.List1_List2;

public class MergeTwoSortedList {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }

        ListNode head = null;
        ListNode tail = null;
        int size =0 ;

        public void addLast(int val) {
            ListNode temp = new ListNode(val);

            if (head == null) {
                head = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

    }

    //This code should only be used if we are allowed to change original list
    //like in merge sort we have to change original list to reach ans
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

    // if you are not allowed to change original list


    public ListNode mergeTwoSortedList1(ListNode l1, ListNode l2) {
        // Without changing given linkedlist -> requirement of portal
        ListNode t1 = l1.head;
        ListNode t2 = l2.head;

        ListNode res = new ListNode(-1);

        while(t1 != null && t2 != null) {
            if(t1.val < t2.val) {
                res.addLast(t1.val);
                t1 = t1.next;
            } else {
                res.addLast(t2.val);
                t2 = t2.next;
            }
        }

        // t1 left over
        while(t1 != null) {
            res.addLast(t1.val);
            t1 = t1.next;
        }

        // t2 left over
        while(t2 != null) {
            res.addLast(t2.val);
            t2 = t2.next;
        }
        return res.next;
    }

}
