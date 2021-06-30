package TREE.BINARY_TREE.PostOrderTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;
import static TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.construct;

public class D_SumOfAllNodes {

    //Cant use P1 (work in Prephase , Preorder traversal) as
    //will have to change function call ,need extra argument to track ans
    //cannot write basecase to exit from recursion only after visiting every node
    // so will have to write many checks

    //If you notice carefully ,The output of PostOrder Traversal
    //It Prints the root Node in the end after visiting all nodes
    //that is it ensures automatically that recursion exits after visiting every node
    //the only base case we have to write is to return 0 if we point to null node

    //Sum of all nodes can be written as
    //Sum of root.val + sum of lst nodes.val + sum of rst nodes.val
    //Possible by POSTORDER TRAVERSAL
    //From this I can deduce it Belongs to
    //Type R2 : Work in PostPhase :Return ans in PostPhase: Multiple Rec Call

    public static int sum(TreeNode node) {
        if(node == null) return 0;

        int SumOfAllNodesInLeftBT = sum(node.left);
        int SumOfAllNodesInRightBT = sum(node.right);

        int SumOfAllNodesAfterCurrNode= SumOfAllNodesInLeftBT + SumOfAllNodesInRightBT;

        int SumOfAllNodesIncludingCurrNode = SumOfAllNodesAfterCurrNode + node.val;

        return SumOfAllNodesIncludingCurrNode;
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

        int sum = sum(root);
        System.out.println(sum);

    }
}
