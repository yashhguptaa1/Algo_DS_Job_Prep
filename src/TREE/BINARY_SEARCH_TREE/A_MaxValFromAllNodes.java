package TREE.BINARY_SEARCH_TREE;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class A_MaxValFromAllNodes {

    //Max value can be only present in right subtree of RootNode
    //if there is no RST then RootNode Val is the max value possible
    //thus we must go as right as possible
    public static int max(TreeNode node) {
        // write your code here

        if(node == null)
            return Integer.MIN_VALUE;

        else if(node.right == null)
            return node.val;

        return max(node.right);
    }

}
