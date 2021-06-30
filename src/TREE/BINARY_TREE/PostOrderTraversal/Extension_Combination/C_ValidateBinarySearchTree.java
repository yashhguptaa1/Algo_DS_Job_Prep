package TREE.BINARY_TREE.PostOrderTraversal.Extension_Combination;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class C_ValidateBinarySearchTree {

    class BSTPair{
        boolean isBst;
        long min;
        long max;
    }


    public BSTPair isBST(TreeNode node)
    {
        if(node == null)
        {
            BSTPair bp = new BSTPair();
            bp.min = Long.MAX_VALUE;
            bp.max = Long.MIN_VALUE;
            bp.isBst = true;
            return bp;
        }

        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);

        BSTPair mp=new BSTPair();

        mp.isBst = lp.isBst && rp.isBst &&
                (node.val > lp.max && node.val < rp.min);

        mp.min=Math.min(node.val,Math.min(lp.min,rp.min));
        mp.max=Math.max(node.val,Math.max(lp.max,rp.max));

        return mp;

    }

    public boolean isValidBST(TreeNode root) {

        BSTPair res = isBST(root);

        return res.isBst;
    }

}
/*
98. Validate Binary Search Tree
Medium

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */