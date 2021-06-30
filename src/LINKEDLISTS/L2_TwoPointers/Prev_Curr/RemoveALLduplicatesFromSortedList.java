package LINKEDLISTS.L2_TwoPointers.Prev_Curr;

public class RemoveALLduplicatesFromSortedList {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
            return head;

        //since we are deleting all nodes if duplicate present
        //we want a pointer just before start of duplicate sublist
        ListNode dummyHeadNode=new ListNode(-1);
        dummyHeadNode.next=head;
        ListNode p=dummyHeadNode;

        //Our current node is p
        //then we compare first node of duplicate sublist (p.next)
        //to second node of duplicate sublist (p.next.next)
        while(p.next != null && p.next.next!=null)
        {
            //if they are duplicate store duplicate value
            if(p.next.val == p.next.next.val)
            {
                int dup=p.next.val;

                // After current node p
                // we go on deleting every duplicate node one by one
                while(p.next!=null && p.next.val == dup)
                {
                    p.next=p.next.next;
                }
            }

            else{
                p=p.next;
            }
        }

        return dummyHeadNode.next;
    }
}
