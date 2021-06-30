package LINKEDLISTS.L2_TwoPointers.List1_List2;

public class AddTwoNumbersAsLists {
    /*
    From INTERVIEWBIT
    You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
     */

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public ListNode addTwoNumbers(ListNode A, ListNode B) {

        ListNode l1= A;
        ListNode l2= B;

        ListNode resHead=new ListNode(-1);
        ListNode t=resHead;

        int carry = 0;

        while(l1 != null || l2 != null || carry != 0)
        {
            int val1 = l1 == null ? 0:l1.val;
            l1 = l1 == null ? null : l1.next;

            int val2 = l2 == null ? 0:l2.val;
            l2 = l2 == null ? null : l2.next;

            int sum = val1 + val2 + carry;
            int val = sum %10;
            carry =sum /10;

            ListNode newNode =new ListNode(val);
            t.next = newNode;
            t=newNode;

        }

        return resHead.next;
    }



}

    /*
    PEPCODING
     */
    /*

    QUESTION
    2. You are required to complete the body of addLinkedLists function. The function is passed two linked lists which represent two numbers - the first element is the most significant digit and the last element is the least significant digit. The function is expected to add the two linked list and return a new linked list.

The following approaches are not allowed :
    1. Don't reverse the linked lists in order to access them from least significant digit
     to most significant.
     2. Don't use arrays or explicit extra memory.
     3. Don't convert linked lists to number, add them up and convert the result back
     to a linked list.

Hint - You are expected to take help of recursion to access digits from least significant to most significant. You have to tackle the challenge of unequal size of lists and manage carry where required.

Solution

// addition of linkedlist using recursion
    public static int additionHelper(Node one, int i1, Node two, int i2, LinkedList res) {
        if(one == null && two == null) {
            return 0;
        }

        int d1 = one.data;
        int d2 = two.data;
        int sum = 0;
        if(i1 > i2) {
            int carry = additionHelper(one.next, i1 - 1, two, i2, res);
            sum = d1 + carry;
        } else if(i1 < i2) {
            int carry = additionHelper(one, i1, two.next, i2 - 1, res);
            sum = d2 + carry;
        } else {
            int carry = additionHelper(one.next, i1 - 1, two.next, i2 - 1, res);
            sum = d1 + d2 + carry;
        }

        res.addFirst(sum % 10);
        return sum / 10;
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
        LinkedList res = new LinkedList();
        int carry = additionHelper(one.head, one.size, two.head, two.size, res);
        if(carry > 0)
            res.addFirst(carry);

        return res;
    }

     */

