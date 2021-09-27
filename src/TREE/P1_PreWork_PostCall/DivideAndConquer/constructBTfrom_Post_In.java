package TREE.P1_PreWork_PostCall.DivideAndConquer;

import java.util.*;

public class constructBTfrom_Post_In {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructPostIn(int[] post, int[] in, int poSt, int poEnd, int inSt, int inEnd) {

        // BC : for creation of NULL nodes, children of LEAF
        if (poSt > poEnd)
            return null;

        // PRE PHASE WORK

        // DIVIDING FACTOR : root node of respective subtree
        TreeNode root = new TreeNode(post[poEnd]);

        // find presence of root node in inorder with indexVariable indx
        int indx = inSt;
        while (in[indx] != post[poEnd])
            indx++;

        // get all elements present in leftsubtree
        int elementCount = indx - inSt;

        // POST RECURSIVE CALLs : CONQUERING lst and rst

        // Updated members to be passed in LEVEL recursive call
        // poEnd : all nodes in LST of curr root node excluding root node
        // : so for next call => poSt + elementCount - 1
        // inEnd : Element at indx in inorder array is the current root node
        // : so for next call => indx-1
        root.left = constructPostIn(post, in, poSt, poSt + elementCount - 1, inSt, indx - 1);

        // poEnd : Element at poEnd in postorder array is the current root node
        // : so for next call => poEnd-1
        root.right = constructPostIn(post, in, poSt + elementCount, poEnd - 1, indx + 1, inEnd);

        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;

        return constructPostIn(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
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

    public static Scanner scn = new Scanner(System.in);

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}