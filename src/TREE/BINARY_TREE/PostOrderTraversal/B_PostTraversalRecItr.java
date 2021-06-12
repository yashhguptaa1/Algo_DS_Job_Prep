package TREE.BINARY_TREE.PostOrderTraversal;

import java.util.*;
import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class B_PostTraversalRecItr {

    // postArea -> area after all calls
    public static void postOrder(TreeNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    //ITERATIVELY
    //For every node track the
    //Recursive call pointer
    //For Iterative codes its
    //the iteration point of loop
    //3 stages of pointer
    //PreOrder :denoted by 0
    //InOrder :denoted by 1
    //PostOrder :denoted by 2
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

        if(node == null)
            return post;

        Stack<Pair> st =new Stack<>();
        st.push(new Pair(node, 0));

        while(st.size() > 0) {
            Pair p = st.peek();
            if(p.state == 0) {

                //In below line leaf nodes will be appended to result
                //we wont store them in stack
                //pre.add(p.node.data);

                //Increment iterative pointer
                p.state++;

                if(p.node.left != null) {
                    st.push(new Pair(p.node.left, 0));
                }
            } else if(p.state == 1) {

                //in.add(p.node.data);

                p.state++;
                if(p.node.right != null) {
                    st.push(new Pair(p.node.right, 0));
                }
            } else {

                post.add(p.node.val);

                st.pop();
            }
        }
        return post;
    }
}
