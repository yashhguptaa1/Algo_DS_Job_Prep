package STACKS.Category_S3;

import java.util.*;
public class TREEInorderTraversalwoRec {


//      Definition for binary tree
      class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
           val = x;
           left=null;
           right=null;
          }
      }

    public class Solution {
        public ArrayList<Integer> inorderTraversal(TreeNode node) {

            ArrayList<Integer>inorder=new ArrayList<>();
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

                //LEFT SUBTREE
                //go as left as possible
                //the stack keeps the history of nodes that we have traversed and need searching
                while(currPtr != null)
                {
                    st.push(currPtr);
                    currPtr=currPtr.left;
                }

                //currPtr is null now
                //investigate the node on top of stack

                //NODE ITSELF
                //As we cannot go left anymore
                //Pull out the most recent visited node(stack tracks this for us)
                //Process it ( just add to list)
                currPtr = st.pop();
                inorder.add(currPtr.val);

                //RIGHT SUBTREE
                //Now do the same routine for right subtree
                currPtr = currPtr.right;

            }
            return inorder;
        }

    }

}

/*
Given a binary tree, return the inorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,3,2].

Using recursion is not allowed.
 */