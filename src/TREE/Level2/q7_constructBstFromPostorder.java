package TREE.Level2;

import java.util.*;

public class q7_constructBstFromPostorder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int indx = 0;

    public static TreeNode bstFromPostorder(int[] post, int leftRange, int rightRange) {

        // BC : to stop recursion => if traversed all the given nodes
        // Edge Case: create a new node using current val only if its in range
        if (indx < 0 || post[indx] < leftRange || rightRange < post[indx]) {
            return null;
        }

        // PREPHASE
        // work for Level
        int val = post[indx--];

        // LEVEL : current root node
        TreeNode root = new TreeNode(val);

        // 2 OPTIONS : 1)lst 2)rst
        root.right = bstFromPostorder(post, val, rightRange);
        root.left = bstFromPostorder(post, leftRange, val);

        return root;
    }

    public static TreeNode constructTree(int post[]) {
        indx = post.length - 1;
        return bstFromPostorder(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructTree(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}