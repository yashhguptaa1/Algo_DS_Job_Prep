package TREE.Level2;

import java.util.*;

public class q23_DiagonalOrderTraversal {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> solve(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        ArrayList<ArrayList<Integer>> res = diagonalOrder(root);

        for (ArrayList<Integer> t : res) {
            for (int x : t) {
                ans.add(x);
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {

        // qu: to store breakpoints(starting points) in each Diagonal
        Queue<TreeNode> qu = new LinkedList<>();

        // Diag 0 starts at root node
        qu.add(root);

        // result list to store all diagonals
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        // traverse all elements
        while (qu.size() > 0) {

            // number of breakpoints
            int factorSize = qu.size();

            // list: to store elements of current diagonal
            ArrayList<Integer> list = new ArrayList<>();

            // Looping over all breakpoints for traversing current diagonal
            while (factorSize-- > 0) {

                // get a breakpoint
                TreeNode factor = qu.remove();

                // go as right as possible
                while (factor != null) {

                    // add elements to current diagonal list
                    list.add(factor.val);

                    // add elements for next diagonal traversal to qu
                    if (factor.left != null)
                        qu.add(factor.left);

                    factor = factor.right;
                }
            }
            res.add(list);
        }
        return res;
    }
}
