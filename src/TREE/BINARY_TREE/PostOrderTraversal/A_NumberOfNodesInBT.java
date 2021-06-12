package TREE.BINARY_TREE.PostOrderTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;
import static TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.construct;

public class A_NumberOfNodesInBT {

    //I have
    //RootNode and Lst and Rst
    //Size of tree will be
    //size of lst + size of rst +  current node size which is 1 (node)


    //Basically i want to obtain size of lst and rst first
    //then add rootnode to it
    //USE POSTORDER TRAVERSAL

    //return the size

    //RECURSION WITH RETURN TYPE of INT
    //Type R3.P2 : Work in PostPhase

    public static int size(TreeNode node) {
        if(node == null) return 0;

        int SizeOfLeftBTafterCurrNode = size(node.left);
        int SizeOfRightBTafterCurrNode = size(node.right);

        int SizeOfCurrentNode = 1;

        int SizeOfBTIncludingCurrNode = SizeOfLeftBTafterCurrNode + SizeOfRightBTafterCurrNode + SizeOfCurrentNode;

        return SizeOfBTIncludingCurrNode;
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

        int size = size(root);
        System.out.println(size);

    }
}
