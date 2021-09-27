package TREE.P1_PreWork_PostCall.DivideAndConquer;

import java.util.*;

public class constructBTfrom_Pre_In {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructPreIn(int[] pre, int[] in, int preSt, int preEnd, int inSt, int inEnd) {

        // BC : for creation of NULL nodes, children of LEAF
        if (preSt > preEnd)
            return null;

        // PRE PHASE WORK

        // DIVIDING FACTOR : root node of respective subtree
        TreeNode root = new TreeNode(pre[preSt]);

        // find presence of root node in inorder with indexVariable indx
        int indx = inSt;
        while (in[indx] != pre[preSt])
            indx++;

        // get all elements present in leftsubtree
        int elementCount = indx - inSt;

        // POST RECURSIVE CALLs : CONQUERING lst and rst

        // Updated members to be passed in LEVEL recursive call
        // preSt : Element at preSt in preorder array is the current root node
        // : so for next call => preSt + 1
        // preEnd : all nodes in LST of curr root node
        // : so for next call => preSt + elementCount
        // inEnd : Element at indx in inorder array is the current root node
        // : so for next call => indx-1
        root.left = constructPreIn(pre, in, preSt + 1, preSt + elementCount, inSt, indx - 1);

        // preSt :
        // inSt :
        root.right = constructPreIn(pre, in, preSt + elementCount + 1, preEnd, indx + 1, inEnd);

        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        return constructPreIn(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}