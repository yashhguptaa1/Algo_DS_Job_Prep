package TREE.BINARY_SEARCH_TREE;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class B_MinValFromAllNodes {

    //Min value can be only present in left subtree of RootNode
    //if there is no LST then RootNode Val is the minimum value possible
    //thus we must go as left as possible
    public int minValue(TreeNode node)
    {
        //If the tree is empty,or no LST
        // there is no minimum elemnt,
        //so return -1 in that case.
        if(node == null)
            return -1;

        //stop recursion and return ans when there are no more leftmost node
        else if(node.left == null)
        {
            return node.val;
        }

        return minValue(node.left);
    }

}
/*
Given a Binary Search Tree. The task is to find the minimum element in this given BST.

Example 1:

Input:
           5
         /    \
        4      6
       /        \
      3          7
     /
    1
Output: 1
Example 2:

Input:
             9
              \
               10
                \
                 11
Output: 9
 */