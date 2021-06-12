package TREE.BINARY_TREE.PostOrderTraversal;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

    //Humme Leftsubtree nodes aur RightSubtree nodes phle chahiye
    //because these nodes will act as child nodes of the new node that we append
    //aur post phase me jo current node hoga vo parent bnjayega new node ka

    //Use Type R2:Work in PostPhase : Multiple Recursive calls

public class I_TransBackFromLeftCloned {

    public static TreeNode transBackFromLeftClonedTree(TreeNode node){
        if(node == null) return null;

        TreeNode leftNormalizedNode = transBackFromLeftClonedTree(node.left.left);
        TreeNode rightChildNode = transBackFromLeftClonedTree(node.right);

        node.left = leftNormalizedNode;
        node.right = rightChildNode;

        return node;
    }

}
