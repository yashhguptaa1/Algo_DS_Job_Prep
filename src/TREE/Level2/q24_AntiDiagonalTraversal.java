package TREE.Level2;
import java.util.*;

public class q24_AntiDiagonalTraversal {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // diagonal anticlock-wise
    public static ArrayList<ArrayList<Integer>> diagonalOrderAntiClockWise(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        while(qu.size() > 0) {
            int factorSize = qu.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(factorSize-- > 0) {
                TreeNode factor = qu.remove();
                while(factor != null) {
                    list.add(factor.val);
                    if(factor.right != null)
                        qu.add(factor.right);

                    factor = factor.left;
                }
            }
            res.add(list);
        }
        return res;
    }
    
}
