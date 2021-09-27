package TREE.Level2;

public class q5_constructFrom_Inorder {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode constructBST_using_In(int[] in, int lo, int hi) {

        // BC : for creation of NULL nodes, children of LEAF
        if (lo > hi)
            return null;

        // PRE PHASE WORK

        // DIVIDING FACTOR : mid = to find index of current root node
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(in[mid]);

        // POSTORDER RECURSIVE CALL

        // POST RECURSIVE CALLs : CONQUERING lst and rst

        // Updated members to be passed in LEVEL recursive call
        // mid : Element at mid in inorder array is the current root node
        root.left = constructBST_using_In(in, lo, mid - 1);
        root.right = constructBST_using_In(in, mid + 1, hi);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST_using_In(nums, 0, nums.length - 1);
    }
}
