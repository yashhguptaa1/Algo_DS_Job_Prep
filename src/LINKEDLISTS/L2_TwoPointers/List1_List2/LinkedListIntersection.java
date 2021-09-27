package LINKEDLISTS.L2_TwoPointers.List1_List2;

public class LinkedListIntersection {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    //USING DIFFERENCE METHOD
    public ListNode getIntersectionNode(ListNode a, ListNode b) {

        int s1=getSize(a);
        int s2=getSize(b);

        ListNode t1= a;
        ListNode t2 =b;

        if(s1>s2)
        {
            int diff=s1-s2;

            while(diff-- > 0 && t1!=null)
            {
                t1=t1.next;
            }
        }
        else if(s2>s1)
        {
            int diff=s2-s1;

            while(diff-- > 0 && t2!=null)
            {
                t2=t2.next;
            }
        }

        while(t1 != null && t2 != null)
        {
            if(t1.val == t2.val)
            {
                return t1;
            }
            t1=t1.next;
            t2=t2.next;
        }
        return null;
    }

    public int getSize(ListNode n)
    {
        int count=0;
        ListNode t=n;

        while(t!=null)
        {
            count++;
            t=t.next;
        }
        return count;
    }
}
