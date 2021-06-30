package LINKEDLISTS.L2_TwoPointers.Prev_Curr;

public class RemoveDuplicatesFromSortedList {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

/*    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode temp = head;
        ListNode itr = head.next;

        while(itr != null)
        {

            if(temp.val != itr.val)
            {
                temp.next = itr;
                temp=temp.next;
            }

            itr=itr.next;
        }
        //if our last node was also part of duplicate sequence
        temp.next=itr;

        return head;
    }
}
*/

//
//USING ONLY SINGLE POINTER

 // Compare this solution with Remove duplicates II
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode prev = head;

        //Here our prev pointer points to first node of duplicate sublist
        //In each iteration We delete nodes after this first node by changing
        //.next of first node of duplicate sublist untill we get non duplicate

        while( prev!= null && prev.next != null){
            if(prev.val == prev.next.val){
                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }

        return head;
    }
}

