package TREE.Level2;

public class maxPathSum {

    static int maxPath = 0;

    private int maxPathSum_(TreeNode root) {

        // BC
        if (root == null)
            return (int) -1e9;

        // PRE RECURSIVE CALLS
        int lsum = maxPathSum_(root.left);
        int rsum = maxPathSum_(root.right);

        // POST PHASE WORK
        int val = Math.max(root.val, Math.max(lsum + root.val, rsum + root.val));

        maxPath = Math.max(maxPath, Math.max(val, lsum + root.val + rsum));

        return val;
    }

    public int maxpathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        maxPathSum_(root);
        return maxPath;
    }
}
