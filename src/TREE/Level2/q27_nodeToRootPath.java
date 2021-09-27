package TREE.Level2;

import java.util.*;

public class q27_nodeToRootPath {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // node to root path
    public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
        if (node == null) {
            return new ArrayList<>();
        }
        ArrayList<TreeNode> res = new ArrayList<>();
        if (node.val == data) {
            res.add(node);
            return res;
        }
        ArrayList<TreeNode> lres = nodeToRootPath(node.left, data);
        if (lres.size() > 0) {
            lres.add(node);
            return lres;
        }
        ArrayList<TreeNode> rres = nodeToRootPath(node.right, data);
        if (rres.size() > 0) {
            rres.add(node);
            return rres;
        }
        return res;
    }
}
