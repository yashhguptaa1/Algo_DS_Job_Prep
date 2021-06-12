package TREE.BINARY_TREE.PostOrderTraversal.Extension_Combination;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class B_diameterOfBT {

    static int diameter = 0;

    public int heightForDiameter(TreeNode root) {
        if(root == null) return -1;

        int lh = heightForDiameter(root.left);
        int rh = heightForDiameter(root.right);

        //We add 2 cauz
        //left edge that joins parent node to its leftsubtree
        //right edge that joins parent node to its rightsubtree
        diameter = Math.max(diameter, lh + rh + 2);

        return Math.max(lh, rh) + 1;
    }

    static class DiaPair {
        int dia;
        int ht;

        public DiaPair() {
            this.dia = 0;
            this.ht = -1;
        }
    }

    public DiaPair diameter2(TreeNode root) {
        if(root == null) return new DiaPair();

        DiaPair lres = diameter2(root.left);
        DiaPair rres = diameter2(root.right);

        DiaPair mres = new DiaPair();

        mres.ht = Math.max(lres.ht, rres.ht) + 1;
        mres.dia = Math.max(lres.ht + rres.ht + 2, Math.max(lres.dia, rres.dia));
        return mres;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        DiaPair res = diameter2(root);
        return res.dia;
        // diameter = 0;
        // heightForDiameter(root);
        // return diameter;
    }
}
