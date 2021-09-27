package TREE.Level2;

public class q42_convertSortedDLLtoBST {

    private static TreeNode creationBST(TreeNode head) {
        // BC
        if (head == null)
            return null;

        //PREPHASE WORK

        // to create a Balanced BST 
        // we use principle of finding mid
        TreeNode mid = getMidLL(head);

        // mid.left : mid.prev ptr
        // mid.left.right : mid.prev.next
        if (mid.left != null) {
            mid.left.right = null;
            mid.left = null;
        }

        // mid.right.left = mid.next.prev;
        // mid.right = mid.next;
        TreeNode head2 = mid.right;
        if (mid.right != null) {
            mid.right.left = null;
            mid.right = null;
        }
        // At this point our DLL is divided into three parts
        // head node to mid-1 node
        // mid node
        // head2 node to last node

        //POST RECURSIVE CALLS

        //Edge case
        if (mid != head)
            mid.left = creationBST(head);

        mid.right = creationBST(head2);
        return mid;
    }

    public static TreeNode SortedDLLToBST(TreeNode head) {
        TreeNode root = creationBST(head);
        return root;
    }

    private static TreeNode getMidLL(TreeNode head) {
        TreeNode slow = head;
        TreeNode fast = head.right;

        while (fast != null && fast.right != null) {
            slow = slow.right;
            fast = fast.right.right;
        }
        return slow;
    }
}
