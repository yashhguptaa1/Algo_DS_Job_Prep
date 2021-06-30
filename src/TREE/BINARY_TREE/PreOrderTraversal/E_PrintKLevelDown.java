package TREE.BINARY_TREE.PreOrderTraversal;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

//USES RECURSION.Type_R1_PrePhase.Print_Ans_in_PrePhase;
public class E_PrintKLevelDown {

    public static void printKLevelsDown(TreeNode node, int k){
        if(node == null) return;

        if(k == 0) {
            System.out.println(node.val);
            return;
        }

        printKLevelsDown(node.left, k - 1);
        printKLevelsDown(node.right, k - 1);
    }

}
