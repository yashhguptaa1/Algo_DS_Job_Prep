package TREE.BINARY_TREE.PreOrderTraversal;

import java.util.*;
import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;
//import TREE.BINARY_TREE.A_DisplayBT.CreationDisplayBT.construct;//wrong import
//correct import
import static TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.construct;
import static TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.display;


public class B_PreTraversalRecItr {

    // preAre -> area before all calls
    public static void preOrder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode node) {

        List<Integer>preorder = new ArrayList<Integer>();
        Stack<TreeNode> st =new Stack<>();
        TreeNode currPtr = node;

        // We cannot use && in this while loop
        // Cauz our stack is empty at two stages
        //1) in the beginning we have not pushed any node in stack
        //2)when we reach root node again after traversing left subtree
        //its popped out and our stack becomes empty
        // as can be noticed in both the cases
        // if there are still nodes to be traversed
        // our curr Node Ptr wont be pointing to null

        //Also in case a node doesnt have right child
        //currPtr will point to null
        //But at that moment if there are still nodes left to be traversed
        // stack will not be empty at that point

        //Thus as long as nodes are to be traversed one of the condition is true
        while (!st.isEmpty() || currPtr != null)
        {
            //writing preorder.add() here gives incorrect answer

            //LEFT SUBTREE
            //go as left as possible
            //keep on adding these nodes as they will be will be root nodes in future
            //the stack keeps the history of nodes that we have traversed and need searching
            while(currPtr != null)
            {
                preorder.add(currPtr.val);
                st.push(currPtr);
                currPtr=currPtr.left;
            }

            //currPtr is null now
            //investigate the node on top of stack

            currPtr = st.pop();

            //RIGHT SUBTREE
            //Now do the same routine for right subtree
            currPtr = currPtr.right;

        }
        return preorder;
    }

    public static void main(String[] args) {
        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        TreeNode root = construct(arr);

        display(root);
        preOrder(root);
    }
}
