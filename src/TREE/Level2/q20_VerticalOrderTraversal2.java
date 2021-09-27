package TREE.Level2;

import java.util.*;

public class q20_VerticalOrderTraversal2 {

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

    //lh: horizontal distance of root node to leftmost node
    static int lh = 0; // find min in left horizontal
    static int rh = 0; // find max in right horizontal

    public static List<List<Integer>> verticalTraversal(TreeNode root) {

        // Total columns in vertical order traversal
        int wd = width(root);

        // Initialize result list
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < wd; i++)
            res.add(new ArrayList<>());

        // There may be multiple nodes in the same row and same column.
        // In such a case, sort these nodes by their values.
        // Use Priority Queue based on values of nodes instead of sorting

        PriorityQueue<Pair> mainQ = new PriorityQueue<>();// store parent nodes
        PriorityQueue<Pair> childQ = new PriorityQueue<>();// store respective child nodes

        // start from root node
        //lh: declared as static variable whose value is updated by width function
        mainQ.add(new Pair(root, Math.abs(lh)));

        // While traversing current vertical column
        while (mainQ.size() > 0) {

            while (mainQ.size() > 0) {

                // GET parent node
                Pair rem = mainQ.remove();

                // get list that stores all nodes for respective column no. and add curr node
                res.get(rem.count).add(rem.node.val);

                if (rem.node.left != null) {
                    childQ.add(new Pair(rem.node.left, rem.count - 1));
                }
                if (rem.node.right != null) {
                    childQ.add(new Pair(rem.node.right, rem.count + 1));
                }
            }
            // swap the queues
            PriorityQueue<Pair> temp = mainQ;
            mainQ = childQ;
            childQ = temp;
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

    public static Scanner scn = new Scanner(System.in);
    // input_section=================================================

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

        List<List<Integer>> ans = verticalTraversal(root);
        int idx = 0;
        for (List<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
