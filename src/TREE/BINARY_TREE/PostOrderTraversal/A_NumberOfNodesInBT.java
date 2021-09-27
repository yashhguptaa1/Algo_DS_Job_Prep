package TREE.BINARY_TREE.PostOrderTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;
import static TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.construct;

public class A_NumberOfNodesInBT {

    // I have
    // RootNode and Lst and Rst
    // Size of tree will be
    // size of lst + size of rst + size of rootnode which is 1 (node)
    // return the size

    // Basically i want to obtain size of lst and rst first
    // Possible by POSTORDER TRAVERSAL
    // then add rootnode to it

    // Type R2 : Work in PostPhase :Return ans in PostPhase: Multiple Rec Call

    // LEVEL: TreeNode
    // 2 OPTIONS: go to LEFTSUBTREE || go to RIGHTSUBTREE
    public static int size(TreeNode node) {

        // No node there => size = 0
        if (node == null)
            return 0;

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

/*
 * Sample Input 19 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n Sample Output
 * 9
 */