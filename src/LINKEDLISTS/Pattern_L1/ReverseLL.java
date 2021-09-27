package LINKEDLISTS.Pattern_L1;

import java.util.*;

public class ReverseLL {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Requirements
    // Return type: ListNode
    // PRE phase : initialize node to store head of reversed LL
    // LEVEL : current node ptr (rec call, storing nodes till end of LL)
    // POST phase : current node -> next -> next = current node
    // : return ListNode
    // Base case : return head of reversed LL
    public static ListNode reverse(ListNode curr) {

        if (curr == null || curr.next == null) {
            // Note we cannot return NULL here as when code hit base case
            // the reference to last node of orig list is returned and stored in variable
            // headReversedLL
            return curr;
        }

        ListNode headOfRevLL = null;

        headOfRevLL = reverse(curr.next);

        curr.next.next = curr;
        curr.next = null;

        return headOfRevLL;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = reverse(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        scn.close();
    }
}
