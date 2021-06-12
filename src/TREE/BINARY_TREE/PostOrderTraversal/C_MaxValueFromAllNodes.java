package TREE.BINARY_TREE.PostOrderTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;
import static TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.construct;

public class C_MaxValueFromAllNodes {

    // want to exit only after traversing all nodes inculding root : Postorder traversal
// find max in lst and store it
//find max in rst and store it
//compare it with root.val
//the maximum from these three is the max val in BT

//RECURSION WITH RETURN TYPE of INT
//Type R3.P2

    // CONSIDERING OUR TREE STARTS FROM TOP TO BOTTOM
    public static int max(TreeNode node) {
        if(node == null) return Integer.MIN_VALUE;

        int MaxFromAllNodesInLeftBT = max(node.left);
        int MaxFromAllNodesInRightBT = max(node.right);

        int MaxFromAllNodesAfterCurrNode= Math.max(MaxFromAllNodesInLeftBT,MaxFromAllNodesInRightBT);

        //Now compare with Current Node of Current function
        int MaxSoFar = Math.max(MaxFromAllNodesAfterCurrNode , node.val);

        return MaxSoFar;

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


    }
}