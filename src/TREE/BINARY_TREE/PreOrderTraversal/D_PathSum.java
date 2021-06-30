package TREE.BINARY_TREE.PreOrderTraversal;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class D_PathSum {

    //We use PreOrder Traversal cauz we want to return the answer as soon as we find it
    //we dont have to traverse all nodes or no need to exit at root
    //we exit when we get leaf node
    //So postorder traversal is pointless
    // Uses RECURSION.Type_R1_PrePhase.Return_Ans_in_PrePhase;

    //Shorthand Form //Tail Recursion form
    public boolean hasPathSum(TreeNode node, int sumSoFar) {

        if(node == null)
            return false;

        if(node.left == null && node.right == null && sumSoFar == node.val)
        {
            return true;
        }

        return hasPathSum(node.left,sumSoFar - node.val) || hasPathSum(node.right,sumSoFar - node.val);
    }



    public boolean hasPath(TreeNode node,int sumSoFar)
    {
        if(node == null)
            return false;

        if(node.left == null && node.right == null && sumSoFar == node.val)
        {

            return true;
        }

        boolean lres=hasPath(node.left,sumSoFar - node.val);
        boolean rres=hasPath(node.right,sumSoFar - node.val);

        return lres || rres;
    }
}

/*
112. Path Sum
Easy

3294

630

Add to List

Share
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.



Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Example 3:

Input: root = [1,2], targetSum = 0
Output: false
 */