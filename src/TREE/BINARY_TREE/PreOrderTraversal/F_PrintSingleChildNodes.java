package TREE.BINARY_TREE.PreOrderTraversal;
import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;


public class F_PrintSingleChildNodes {

    public static void printSingleChildNodes(TreeNode node, TreeNode parent){
        if(node == null) return;

        if(parent != null && parent.left == node && parent.right == null) {
            // i m single left child of my parent
            System.out.println(node.val);
        }

        if(parent != null && parent.right == node && parent.left == null) {
            // i m single right child of my parent
            System.out.println(node.val);
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

}
/*
The function is expected to print in separate lines, all such nodes which are only child of their parent.
 */