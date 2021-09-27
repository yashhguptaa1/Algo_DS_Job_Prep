package TREE.BINARY_TREE.InorderTraversal;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

import java.util.*;

public class A_InTraversalRecItr {

    public ArrayList<Integer> inorderTraversal(TreeNode node) {

        ArrayList<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode currPtr = node;

        // We cannot use && in this while loop
        // Cauz our stack is empty at two stages
        // 1) in the beginning we have not pushed any node in stack
        // 2)when we reach root node again after traversing left subtree
        // its popped out and our stack becomes empty
        // as can be noticed in both the cases
        // if there are still nodes to be traversed
        // our curr Node Ptr won't be pointing to null

        // Also in case a node doesn't have right child
        // currPtr will point to null
        // But at that moment if there are still nodes present to be traversed
        // stack will not be empty at that point

        // Thus as long as nodes are to be traversed one of the condition is true
        while (!st.isEmpty() || currPtr != null) {

            // LEFT SUBTREE
            // go as left as possible
            // the stack keeps the history of nodes that we have traversed and need
            // searching
            while (currPtr != null) {
                // if we move our currPtr first and then push in stack
                // in end when currPtr will point at null
                // it will be pushed in stack which is incorrect
                st.push(currPtr);
                currPtr = currPtr.left;
            }

            // currPtr is null now
            // investigate the node on top of stack

            // NODE ITSELF
            // As we cannot go left anymore
            // Pull out the most recent visited node(stack tracks this for us)
            // Process it ( just add to list)
            currPtr = st.pop();
            inorder.add(currPtr.val);

            // RIGHT SUBTREE
            // Now do the same routine for right subtree
            currPtr = currPtr.right;

        }
        return inorder;
    }
}

/*
 * 94. Binary Tree Inorder Traversal Easy
 * 
 * Given the root of a binary tree, return the inorder traversal of its nodes'
 * values.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3] Output: [1,3,2] Example 2:
 * 
 * Input: root = [] Output: [] Example 3:
 * 
 * Input: root = [1] Output: [1] Example 4:
 * 
 * 
 * Input: root = [1,2] Output: [2,1] Example 5:
 * 
 * 
 * Input: root = [1,null,2] Output: [1,2]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 100]. -100 <= Node.val <=
 * 100
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
