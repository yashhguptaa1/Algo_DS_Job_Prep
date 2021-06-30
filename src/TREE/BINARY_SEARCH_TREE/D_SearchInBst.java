package TREE.BINARY_SEARCH_TREE;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class D_SearchInBst {

    public TreeNode searchBST(TreeNode root, int val) {

        if(root == null)
            return null;

        if(root.val == val)
            return root;

        else if(val > root.val)
            return searchBST(root.right,val);

        return searchBST(root.left,val);
    }
}
