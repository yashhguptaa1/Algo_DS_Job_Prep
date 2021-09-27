package TREE.Level2;

import java.util.*;

public class q9_BinaryTreeCameras {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int minCameraCover(TreeNode root) {
        countCamera = 0;
        int state = minCamera(root);
        if (state == 2)
            countCamera++;

        return countCamera;
    }

    static int countCamera = 0;

    // state 0 -> Camera present
    // state 1 -> i'm cover
    // state 2 -> i'm unsafe
    public static int minCamera(TreeNode root) {
        if (root == null)
            return 1;

        // POSTORDER RECURSIVE CALL
        int lstate = minCamera(root.left);
        int rstate = minCamera(root.right);

        // POSTPHASE WORK
        if (lstate == 1 && rstate == 1) {
            return 2;
        } else if (lstate == 2 || rstate == 2) {
            countCamera++;
            return 0;
        } else {
            return 1;
        }
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        System.out.println(minCameraCover(root));

    }

    public static void main(String[] args) {
        solve();
    }
}
