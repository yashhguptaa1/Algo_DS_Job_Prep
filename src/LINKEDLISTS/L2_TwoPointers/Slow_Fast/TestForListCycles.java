package LINKEDLISTS.L2_TwoPointers.Slow_Fast;

public class TestForListCycles {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode detectCycle(ListNode h) {

        // If list is empty or has only one node
        // without loop
        if(h==null || h.next == null)
            return null;

        boolean hasCycle=false;

        ListNode slow=h;
        ListNode fast=h;


        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

            if(slow == fast)
            {
                hasCycle=true;
                break;

            }
        }

        if(hasCycle)
        {
            slow=h;

            while (slow != fast)
            {
                slow = slow.next;
                fast = fast.next;
            }
            /* since fast->next is the looping point */
            return slow;// = null; /* remove loop */
        }

        return null;
    }
}
