package TREE.Level2;

import java.util.*;

public class q8_constructFrom_Level {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public class LHelper {
        TreeNode parent;
        int leftRange;
        int rightRange;

        public LHelper(TreeNode parent, int leftRange, int rightRange) {
            this.parent = parent;
            this.leftRange = leftRange;
            this.rightRange = rightRange;
        }
    }

    public TreeNode constructBST(int[] arr) {
        Queue<LHelper> qu = new LinkedList<>();
        qu.add(new LHelper(null, Integer.MIN_VALUE, Integer.MAX_VALUE));
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            TreeNode nn = new TreeNode(arr[i]);
            while (qu.peek().leftRange >= nn.val || qu.peek().rightRange <= nn.val) {
                qu.remove();
            }
            LHelper rem = qu.remove();
            qu.add(new LHelper(nn, rem.leftRange, nn.val));
            qu.add(new LHelper(nn, nn.val, rem.rightRange));

            if (rem.parent == null) {
                root = nn;
            } else if (rem.parent.val > nn.val) {
                rem.parent.left = nn;
            } else {
                rem.parent.right = nn;
            }
        }
        return root;
    }
}
