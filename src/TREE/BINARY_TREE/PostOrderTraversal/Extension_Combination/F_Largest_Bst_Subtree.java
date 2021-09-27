package TREE.BINARY_TREE.PostOrderTraversal.Extension_Combination;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

import java.io.*;

import static TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.construct;

public class F_Largest_Bst_Subtree {

    public static class BSTPair {
        int min;
        int max;
        boolean isbst;
        int largestBstSoFar;

        public BSTPair() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isbst = true;
            largestBstSoFar = 0;
        }
    }
    // static int largestBstSize = 0;
    // static TreeNode ResBstNode = null;

    public static BSTPair largestBST(TreeNode node, int largestBstSize[], TreeNode ResBstNode) {
        if (node == null)
            return new BSTPair();

        BSTPair lres = largestBST(node.left, largestBstSize, ResBstNode);
        BSTPair rres = largestBST(node.right, largestBstSize, ResBstNode);

        boolean isCurrBst = lres.max < node.val && rres.min > node.val;

        BSTPair mres = new BSTPair();
        mres.min = Math.min(node.val, Math.min(lres.min, rres.min));
        mres.max = Math.max(node.val, Math.max(lres.max, rres.max));
        mres.isbst = lres.isbst && rres.isbst && isCurrBst;
        mres.largestBstSoFar = lres.largestBstSoFar + rres.largestBstSoFar + 1;

        if (mres.isbst == true && mres.largestBstSoFar > largestBstSize[0]) {
            ResBstNode = node;
            largestBstSize[0] = mres.largestBstSoFar;
        }

        return mres;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        TreeNode root = construct(arr);
        TreeNode node = null;
        // write your code here
        int ans[] = new int[1];

        BSTPair res = largestBST(root, ans, node);

        System.out.println(node.val + "@" + ans[0]);
    }

}
