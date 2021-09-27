package LINKEDLISTS.L2_TwoPointers.Prev_Curr;
import java.util.*;

public class RemoveALLduplicatesFromSortedList {

    public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null)
            return head;

        //since we are deleting all nodes if duplicate present
        //we want a pointer just before start of duplicate sublist
        ListNode dummyHeadNode=new ListNode(-1);
        dummyHeadNode.next=head;
        ListNode p=dummyHeadNode;

        //p: potential next
        //curr: Our current node is p
        //forw1: then we compare first node of duplicate sublist (p.next)
        //forw2: to second node of duplicate sublist (p.next.next)
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

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());

        ListNode ans = deleteDuplicates(head1);
        printList(ans);
    }


}
