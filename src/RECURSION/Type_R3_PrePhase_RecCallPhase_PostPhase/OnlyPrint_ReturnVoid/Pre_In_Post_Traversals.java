package RECURSION.Type_R3_PrePhase_RecCallPhase_PostPhase.OnlyPrint_ReturnVoid;

import java.util.*;
public class Pre_In_Post_Traversals {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0]);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));

        int indx = 0;
        while (st.size() > 0) {
            Pair p = st.peek();
            if (p.state == 0) {
                // left child processing
                indx++;
                if (arr[indx] != null) {
                    Node nn = new Node(arr[indx]);
                    p.node.left = nn;
                    st.push(new Pair(nn, 0));
                }
                p.state++;
            } else if (p.state == 1) {
                // right child processing
                indx++;
                if (arr[indx] != null) {
                    Node nn = new Node(arr[indx]);
                    p.node.right = nn;
                    st.push(new Pair(nn, 0));
                }
                p.state++;
            } else {
                // pop out node-pair from stack
                st.pop();
            }
        }
        return root;
    }

    // preAre -> area before all calls
    public static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // inAre -> area between the calls i.e. left and right calls
    public static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // postArea -> area after all calls
    public static void postOrder(Node root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

}
