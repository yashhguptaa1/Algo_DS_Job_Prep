package TREE.Level2;
import java.util.*;

public class q38_burningTree {

    static int maxTime = 0;
    private static void burningTree_(TreeNode node, TreeNode blockage, int time) {
        if(node == null || node == blockage) return;

        maxTime = Math.max(maxTime, time);

        burningTree_(node.left, blockage, time + 1);
        burningTree_(node.right, blockage, time + 1);
    }

    public static int solve(TreeNode root, int fireNode) {
        ArrayList<TreeNode> n2rpath = nodeToRootPathNodeType(root, fireNode);
        maxTime = 0;
        TreeNode blockage = null;
        for(int t = 0; t < n2rpath.size(); t++) {
            TreeNode node = n2rpath.get(t);
            burningTree_(node, blockage, t);
            blockage = node;
        }
        return maxTime;
    }
    
    public static ArrayList<TreeNode> nodeToRootPathNodeType(TreeNode node, int data) {
        ArrayList<TreeNode> mres = new ArrayList<>();
        if(node == null) return mres;

        if(node.val == data) {
            mres.add(node);
            return mres;
        }

        ArrayList<TreeNode> lres = nodeToRootPathNodeType(node.left, data);
        if(lres.size() > 0) {
            lres.add(node);
            return lres;
        }
        ArrayList<TreeNode> rres = nodeToRootPathNodeType(node.right, data);
        if(rres.size() > 0) {
            rres.add(node);
            return rres;
        }
        return mres;
    }
    
}
