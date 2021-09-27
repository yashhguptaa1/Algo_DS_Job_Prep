package Z_Competitions;

import java.util.*;

public class Solution {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode getSuccessor(TreeNode root, int givenVal) {

        // a : root node of given tree
        TreeNode givenNode = searchBST(root, givenVal);

        // Case 0 : if given node not found in bst
        if (givenNode == null)
            return null;

        // Case 1 : if node has right subtree
        if (givenNode.right != null) {
            return findMin(givenNode.right);
        }
        // Case 2 : no right subtree
        else {
            TreeNode successor = null;
            TreeNode curr = root;
            while (curr != givenNode) {
                if (givenNode.val < curr.val) {
                    successor = curr;
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            return successor;
        }
    }

    public TreeNode findMin(TreeNode root) {
        if (root == null)
            return null;
        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null)
            return null;

        if (root.val == val)
            return root;

        else if (val > root.val)
            return searchBST(root.right, val);

        return searchBST(root.left, val);
    }
}
