package TREE.BINARY_TREE.PostOrderTraversal.Extension_Combination;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class B_diameterOfBT {

    //THIS SOLUTION IS INEFFICIENT
    //WITH TC: O(n^2)
    //because we traverse nodes again as we call height function
    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {

            return diameter1(root);
        }

        public int diameter1(TreeNode node)
        {
            if(node == null)
                return 0;

            //only in LST
            //maximum distance between two nodes in left hand side
            //Factor 2: Dia endpoints on left side
            int ld =diameter1(node.left);

            //only in RST
            //maximum distance between two nodes in right hand side
            //Factor 3: Dia endpoints on right side
            int rd =diameter1(node.right);

            //Diameter is obtained by considering nodes from LST and RST
            //maximum distance between left's deepest and right's deepest
            // 2 denotes the two edges that connect root node to
            //LST and RST respectivwly
            //Factor 1: Dia endpoints on either side
            int lr = height(node.left) + height(node.right) +2;

            int dia = Math.max(lr,Math.max(ld,rd));

            return dia;
        }

        public int height(TreeNode node)
        {
            if(node == null)
            {
                return -1;
            }

            int lh=height(node.left);
            int rh=height(node.right);
            int maxSoFar=Math.max(lh,rh);

            return maxSoFar+1;
        }
    }

    //THIS SOLUTION IS EFFICIENT
    //WITH TC: O(n)

    //basically we try to combine recursion of height function
    //and diameter by returning two values from same function
    //we make a custom class to return two values from same function
    static class DiaPair {
        int dia;
        int ht;

        public DiaPair() {
            this.dia = 0;
            this.ht = -1;
        }
    }

    public DiaPair diameter2(TreeNode root) {
        if(root == null) return new DiaPair();

        DiaPair lres = diameter2(root.left);
        DiaPair rres = diameter2(root.right);

        DiaPair mres = new DiaPair();

        mres.ht = Math.max(lres.ht, rres.ht) + 1;
        mres.dia = Math.max(lres.ht + rres.ht + 2, Math.max(lres.dia, rres.dia));
        return mres;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        DiaPair res = diameter2(root);
        return res.dia;
        // diameter = 0;
        // heightForDiameter(root);
        // return diameter;
    }
}
/*
543. Diameter of Binary Tree
Easy

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
 */