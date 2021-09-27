package LINKEDLISTS.L2_TwoPointers.List1_List2;

import LINKEDLISTS.L2_TwoPointers.Slow_Fast.A_FindMiddleNodeInLL;

import  java.util.*;

//TC : O(KN log(K))
public class MergeKSortedLists {

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;

        //Default behaviour : minheap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((aThis,bOther) -> {

            //If +ve value returned it means this is greater than other
            //since we need min heap we place smaller value before greater value
            //in queue bOther.val will be stored before aThis.val

            return aThis.val - bOther.val;   //For Min Heap
            //return bOther.val - aThis.val // For Max heap
        });

        //Fill MinHeap with first nodes of all linked lists
        for (ListNode node : lists) {

            //check if given LL is empty
            if (node != null)
                pq.add(node);
        }

        while(pq.size()>0)
        {
            ListNode currNode=pq.remove();

            prev.next = currNode;
            prev=prev.next;

            currNode=currNode.next;
            if(currNode !=null )
                pq.add(currNode);
        }
        return dummyHead.next;
    }

}
/*
23. Merge k Sorted Lists
Hard

7510

362

Add to List

Share
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
 */