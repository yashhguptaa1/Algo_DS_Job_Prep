package TREE.Level2;

public class q36_maxPathSumBetween2Leaf {

    // max path sum between two leaf
    // https://practice.geeksforgeeks.org/problems/maximum-path-sum/1#
    static int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum1(TreeNode node) {

        // PRE PHASE WORK
        int sum = 0;
        if (node.left != null && node.right != null) {

            // conditional PRE RECURSIVE CALLs
            int lsum = maxPathSum1(node.left);
            int rsum = maxPathSum1(node.right);

            // global var to track final ans
            maxPathSum = Math.max(maxPathSum, lsum + rsum + node.val);
            sum = Math.max(lsum, rsum) + node.val;

        } else if (node.left != null) {

            // conditional PRE RECURSIVE CALLs
            int lsum = maxPathSum1(node.left);
            sum = lsum + node.val;
        } else if (node.right != null) {

            // conditional PRE RECURSIVE CALLs
            int rsum = maxPathSum1(node.right);
            sum = rsum + node.val;
        } else {
            sum = node.val;
        }
        return sum;
    }

    public int maxPathSum(TreeNode node) {

        // BC
        if (node == null)
            return 0;

        // PRE PHASE WORK

        // var to track and store final ans
        maxPathSum = Integer.MIN_VALUE;

        if (node.left != null && node.right != null) {

            // conditional PRE RECURSIVE CALLs
            int lsum = maxPathSum1(node.left);
            int rsum = maxPathSum1(node.right);

            maxPathSum = Math.max(maxPathSum, lsum + rsum + node.val);
        } else if (node.left != null) {

            // conditional PRE RECURSIVE CALLs
            int lsum = maxPathSum1(node.left);
            maxPathSum = Math.max(maxPathSum, lsum + node.val);
        } else if (node.right != null) {

            // conditional PRE RECURSIVE CALLs
            int rsum = maxPathSum1(node.right);
            maxPathSum = Math.max(maxPathSum, rsum + node.val);
        } else {
            // maxPathSum = node.data;
        }
        return maxPathSum;
    }
}
