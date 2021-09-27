package TREE.Level2;
import java.util.*;

public class q26_DiagonalOrderSum {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // diagonal order sum
    public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        while(qu.size() > 0) {
            int factorSize = qu.size();
            int sum = 0;
            while(factorSize-- > 0) {
                TreeNode factor = qu.remove();
                while(factor != null) {
                    sum += factor.val;
                    if(factor.left != null)
                        qu.add(factor.left);

                    factor = factor.right;
                }
            }
            res.add(sum);
        }
        return res;
    }    
}
