package TREE.Level2;

public class q11_LongestZigZagPath {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public class ZHelper { // zigzag helper
        int lStart; // if end at left
        int rStart; // if end at right
        int omax; // overall max length

        public ZHelper(int lStart, int rStart, int omax) {
            this.lStart = lStart;
            this.rStart = rStart;
            this.omax = omax;
        }
    }

    public ZHelper longest_ZigZag(TreeNode node) {
        if (node == null)
            return new ZHelper(-1, -1, 0);

        ZHelper left = longest_ZigZag(node.left);
        ZHelper right = longest_ZigZag(node.right);

        int startAtL = left.rStart + 1;
        int startAtR = right.lStart + 1;
        int omax = Math.max(Math.max(left.omax, right.omax), Math.max(startAtL, startAtR));

        return new ZHelper(startAtL, startAtR, omax);
    }

    public int longestZigZag(TreeNode root) {
        ZHelper res = longest_ZigZag(root);
        return res.omax;
    }

}
