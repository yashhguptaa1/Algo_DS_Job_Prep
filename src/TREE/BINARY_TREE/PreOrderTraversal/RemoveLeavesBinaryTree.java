package TREE.BINARY_TREE.PreOrderTraversal;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class RemoveLeavesBinaryTree {

    // As we have to work on leaf nodes
    //Preorder is more preferable
    public static TreeNode removeLeaves1(TreeNode node) {
        if(node == null) return null;

        if(node.left == null && node.right == null) {
            return null;
        }
        node.left = removeLeaves1(node.left);
        node.right = removeLeaves1(node.right);
        return node;
    }

}
