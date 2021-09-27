package TREE.P1_PreWork_PostCall.DivideAndConquer;

import java.util.*;

public class constructBTfrom_Post_Pre {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructPrePost(int[] pre, int[] post, int preSt, int preEnd, int poSt, int poEnd) {

        // BC : for creation of LEAF node
        if (preSt == preEnd)
            return new TreeNode(pre[preSt]);

        // BC : for creation of NULL nodes, children of LEAF
        if (preSt > preEnd)
            return null;

        // PRE PHASE WORK

        // DIVIDING FACTOR
        // get root node of current subtree from preorder
        TreeNode root = new TreeNode(pre[preSt]);

        // get left root node of current subtree
        int ele = pre[preSt + 1];

        // get all elements present in leftsubtree using postorder array
        int indx = poSt;
        while (post[indx] != ele) {
            indx++;
        }
        int elementCount = indx - poSt + 1;

        // POST RECURSIVE CALLs : CONQUERING lst and rst

        // Updated members to be passed in LEVEL recursive call
        // preSt + 1 : LST root node
        // indx : elements in LST present in postorder array
        // poEnd : current subtree root node
        // : so for next call => poEnd-1
        root.left = constructPrePost(pre, post, preSt + 1, preSt + elementCount, poSt, indx);
        root.right = constructPrePost(pre, post, preSt + elementCount + 1, preEnd, indx + 1, poEnd - 1);

        return root;
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre.length == 0)
            return null;
        return constructPrePost(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    // input_section=================================================
    public static Scanner scn = new Scanner(System.in);

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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = constructFromPrePost(pre, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
