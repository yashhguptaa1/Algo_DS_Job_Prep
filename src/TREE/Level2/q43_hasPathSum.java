package TREE.Level2;

public class q43_hasPathSum {

    private boolean hasPathSum_(TreeNode node, int target, int ssf) {

        //BC
        if (node == null)
            return false;

        //PRE PHASE WORK
        if (node.left == null && node.right == null) {
            return ssf + node.val == target;
        }

        //POST RECURSIVE CALLS and return
        return hasPathSum_(node.left, target, ssf + node.val) || hasPathSum_(node.right, target, ssf + node.val);
    }

    public boolean hasPath(TreeNode root, int targetSum) {
        return hasPathSum_(root, targetSum, 0);
    }
}
