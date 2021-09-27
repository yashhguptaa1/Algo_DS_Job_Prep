package LINKEDLISTS.L2_TwoPointers.Prev_Curr;
import java.util.*;

public class RemoveNthNodeFromEnd {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        //s1: 2ptrs
        ListNode forw=head;
        ListNode curr=null;

        //For n=1 we can lose head node
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        curr=dummyHead;

        //q1:According to Constraints given n will always be valid

        while(forw!=null)
        {
            //s2: Place curr at nth from head
            if(n-- > 0)
                forw=forw.next;

                //s3: get to node just before nth node
            else{
                curr=curr.next;
                forw=forw.next;
            }
        }

        //s4 delete nth node
        curr.next=curr.next.next;

        return dummyHead.next;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static Scanner scn = new Scanner(System.in);

    public static ListNode createList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = scn.nextInt();
        ListNode h1 = createList(n);

        int m = scn.nextInt();
        h1 = removeNthFromEnd(h1, m);
        printList(h1);
    }
}
