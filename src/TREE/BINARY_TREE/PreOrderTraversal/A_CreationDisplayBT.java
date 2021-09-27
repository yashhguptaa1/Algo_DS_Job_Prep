package TREE.BINARY_TREE.PreOrderTraversal;

import java.util.*;

public class A_CreationDisplayBT {

    public static class TreeNode {

        // made public afterwards so that they can be accessed outside package by other
        // classes
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        public TreeNode(int x, TreeNode lcn, TreeNode rcn) {
            val = x;
            left = lcn;
            right = rcn;
        }
    }

    public static class Pair {
        TreeNode node;
        int state;

        public Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    // USES TYPE R1 : PRINT ANS IN PREPHASE

    public static void display(TreeNode root) {
        if (root == null)
            return;

        String str = root.left == null ? " ." : "" + root.left.val;
        str += " <- [" + root.val + "] -> ";
        str += root.right == null ? ". " : root.right.val;
        System.out.println(str);

        display(root.left);
        display(root.right);
    }

    // For p.state if
    // 0 -> Process Left child = Pre
    // 1 -> Process right child= In
    // 2 -> Pop the current node from stack = Post
    public static TreeNode construct(Integer[] arr) {

        // Make first element of array as ROOT of BT
        TreeNode root = new TreeNode(arr[0]);

        // Stack to track states of Previous nodes
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));

        // To traverse input array
        int indx = 0;

        while (st.size() > 0) {
            Pair p = st.peek();
            if (p.state == 0) {
                indx++;
                if (arr[indx] != null) {

                    // Since TreeNode constructor initializes
                    // node.left as null
                    // node.right as null
                    // so if we get a null (no child present)
                    // we dont explicitly set node.left= null
                    TreeNode nn = new TreeNode(arr[indx]);
                    p.node.left = nn;
                    st.push(new Pair(nn, 0));
                }

                // if no more left child that is if we get NULL
                // increment state so that we can now start adding child in right half
                p.state++;
            } else if (p.state == 1) {
                indx++;
                if (arr[indx] != null) {
                    TreeNode nn = new TreeNode(arr[indx]);
                    p.node.right = nn;
                    st.push(new Pair(nn, 0));
                }

                // if no more right child or if we get NULL
                // increment state so that we can pop the curr Node
                // denotes for curr node all its child have been added
                p.state++;
            } else {
                // pop out node-pair from stack
                st.pop();
            }
        }
        return root;
    }

    public static void main(String[] args) {

        Integer[] arr = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        TreeNode root = construct(arr);

        display(root);

    }
}
