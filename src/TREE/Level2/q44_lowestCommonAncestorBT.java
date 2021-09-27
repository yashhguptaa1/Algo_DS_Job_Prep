package TREE.Level2;

public class q44_lowestCommonAncestorBT {
    // LCA without node to root path
    static TreeNode lca = null;

    private static boolean solveLCA(TreeNode node, int data1, int data2) {

        // BC
        if (node == null)
            return false;

        // PRE PHASE WORK
        // self : selfcheck : check if current node is one of the given node
        boolean self = node.val == data1 || node.val == data2;

        // IN RECURSIVE CALLS
        boolean left = false, right = false;
        left = solveLCA(node.left, data1, data2);

        // EC : if lca found then dont make any future recursive calls
        if (lca == null)
            right = solveLCA(node.right, data1, data2);

        // POST PHASE WORK
        // Case 1 : data1 = currnode , data2 = node from lst
        // Case 2 : data1 = currnode , data2 = node from rst
        // Case 3 : data 1 = node from lst , data2 = node from rst
        if ((self && left) || (self && right) || (left && right)) {
            lca = node;
        }
        return self || left || right;
    }

    public static TreeNode lowestCommonAncestor(TreeNode node, int p, int q) {
        lca = null;
        solveLCA(node, p, q);
        return lca;
    }
}
