package TREE.BINARY_TREE.PostOrderTraversal.Extension_Combination;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class E_BalancedBinaryTree {

    public class BalPair{
        int ht;
        boolean isBal;
    }

    public boolean isBalanced(TreeNode root) {

        BalPair bal=util(root);
        return bal.isBal ;
    }

    public BalPair util(TreeNode node)
    {
        if(node == null)
        {
            BalPair bp = new BalPair();
            bp.ht = 0;
            bp.isBal=true;
            return bp;
        }

        BalPair lp = util(node.left);
        BalPair rp = util(node.right);

        BalPair mp = new BalPair();

        boolean isBalAsVal = Math.abs(lp.ht - rp.ht)<=1;
        boolean isBalAsNode = lp.isBal && rp.isBal;
        mp.isBal = isBalAsVal && isBalAsNode;

        mp.ht = Math.max(lp.ht,rp.ht)+1;

        return mp;
    }

}
/*
110. Balanced Binary Tree
Easy

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 */