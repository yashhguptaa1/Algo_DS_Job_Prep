package TREE.BINARY_SEARCH_TREE;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class E_AddLeafNodesInBst {
    public static TreeNode add(TreeNode node, int data) {
        // write your code here

        if(node == null)
        {
            return new TreeNode(data,null,null);
        }

        if(data > node.val)
        {
            node.right=add(node.right,data);
        }
        else if(data<node.val)
        {
            node.left=add(node.left,data);
        }

        return node;
    }

}
