package TREE.Level2;

import java.util.*;

public class q21_BottomView {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class Pair implements Comparable<Pair> {
        TreeNode node;
        int count;

        public Pair(TreeNode node, int count) {
            this.node = node;
            this.count = count;
        }

        public int compareTo(Pair o) {
            return this.node.val - o.node.val;
        }
    }

    // lh: horizontal distance of root node to leftmost node
    static int lh = 0; // find min in left horizontal
    static int rh = 0; // find max in right horizontal

    public ArrayList<Integer> bottomView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        lh = 0;
        rh = 0;
        int wd = width(root);

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < wd; i++)
            res.add(null);

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root, Math.abs(lh)));

        while (qu.size() > 0) {
            // 1. get + remove
            Pair rem = qu.remove();
            // 2. work
            // if(res.get(rem.count) == null)
            res.set(rem.count, rem.node.val);
            // 3. add children
            if (rem.node.left != null) {
                qu.add(new Pair(rem.node.left, rem.count - 1));
            }
            if (rem.node.right != null) {
                qu.add(new Pair(rem.node.right, rem.count + 1));
            }
        }
        return res;
    }

    // Width of shadow of binary tree
    public static int width(TreeNode root) {
        if (root == null)
            return 0;
        lh = 0;
        rh = 0;
        width(root, 0);
        return rh - lh + 1;
    }

    private static void width(TreeNode root, int count) {
        if (root == null)
            return;

        if (count < lh) {
            lh = count;
        } else if (count > rh) {
            rh = count;
        }

        width(root.left, count - 1);
        width(root.right, count + 1);
    }

}
