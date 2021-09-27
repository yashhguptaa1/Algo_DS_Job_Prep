package TREE.BINARY_TREE.PostOrderTraversal;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class G_CreateALeftClonedTree {

    // Humme Leftsubtree nodes aur RightSubtree nodes phle chahiye
    // because these nodes will act as child nodes of the new node that we append

    // aur post phase me jo current node hoga vo parent bnjayega new node ka

    // Use RECURSION.Type_R2_PostPhase.Work_ReturnAns_in_PostPhase.MultipleRecCall

    public static TreeNode createLeftCloneTree(TreeNode node) {
        if (node == null)
            return null;

        TreeNode lcn = createLeftCloneTree(node.left); // left child node
        TreeNode rcn = createLeftCloneTree(node.right);// right child node

        TreeNode nn = new TreeNode(node.val, lcn, null);
        node.left = nn;
        node.right = rcn;

        return node;
    }

}
/*
 * The function is expected to create a new node for every node equal in value
 * to it and inserted between itself and it's left child. Check question video
 * for clarity.
 */