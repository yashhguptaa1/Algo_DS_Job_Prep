package TREE.Level2;

public class q6_1008_constructFrom_Preorder {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    int indx = 0;
    public TreeNode bstFromPreorder(int[] pre, int leftRange, int rightRange) {

        // BC : to stop recursion => if traversed all the given nodes
        // Edge Case: create a new node using current val only if its in range
        if (indx >= pre.length || pre[indx] < leftRange || rightRange < pre[indx]) {
            return null;
        }

        // PREPHASE
        // work for Level
        int val = pre[indx++];

        // LEVEL : current root node
        TreeNode root = new TreeNode(val);

        // 2 OPTIONS : 1)lst 2)rst
        root.left = bstFromPreorder(pre, leftRange, val);
        root.right = bstFromPreorder(pre, val, rightRange);

        return root;
    }

    public TreeNode bstFromPreorder(int[] pre) {
        indx = 0;
        return bstFromPreorder(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
