package LINKEDLISTS.Pattern_L1;

public class ReverseLL {

    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

    //Recursive

    public ListNode reverseListRec(ListNode currNode) {

        //Edge Case || Base Case
        if(currNode==null || currNode.next == null)
        {//Note we cannot return NULL here as when code hit base case
            //the reference to last node of orig list is returned and stored in variable
            //headReversedLL
            return currNode;
        }


        ListNode headReversedLL=reverseListRec(currNode.next);
        currNode.next.next=currNode;
        currNode.next=null;

        return headReversedLL;
    }


}
