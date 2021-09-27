package TREE.BINARY_TREE.PostOrderTraversal;

import java.util.*;
import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class B_PostTraversalRecItr {

    // postArea -> area after all calls
    public static void postOrder(TreeNode root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    // ITERATIVELY
    // For every node track the
    // Recursive call pointer
    // For Iterative codes its
    // the iteration point of loop
    // 3 stages of pointer
    // PreOrder :denoted by 0
    // InOrder :denoted by 1
    // PostOrder :denoted by 2
    class Pair {
        TreeNode node;
        int state;

        public Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public List<Integer> postorderTraversal(TreeNode node) {

        List<Integer> post = new ArrayList<>();

        if (node == null)
            return post;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, 0));

        while (st.size() > 0) {
            Pair p = st.peek();
            if (p.state == 0) {

                // pre.add(p.node.data);

                // if Curr Node has left child add it
                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 0));
                }

                // For curr node as left child has been already stored
                // Increment state so that next time right child is stored for curr Node
                p.state++;
            } else if (p.state == 1) {

                // in.add(p.node.data);

                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 0));
                }

                // For curr node as right child has been already stored
                // Increment state so that next time we pop out curr Node as its lst and rst
                // have been stored
                p.state++;
            } else {

                post.add(p.node.val);
                st.pop();
            }
        }
        return post;
    }
}
