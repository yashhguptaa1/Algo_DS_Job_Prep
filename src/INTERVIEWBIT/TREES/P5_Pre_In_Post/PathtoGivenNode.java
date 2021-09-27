package INTERVIEWBIT.TREES.P5_Pre_In_Post;
import java.util.*;

public class PathtoGivenNode {

    public ArrayList<Integer> path(TreeNode node, int x) {
        // BC : to exit recursion
        if (node == null)
            return new ArrayList<>();

        // PRE PHASE WORK
        // BC : to store and return answer
        if (node.val == x) {
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.val);
            return bres;
        }

        // PRE RECUSRIVE CALL
        ArrayList<Integer> lres = path(node.left, x);

        // IN PHASE WORK
        if (lres.size() > 0) {
            lres.add(node.val);
            return lres;
        }

        // POST RECURSIVE CALL
        ArrayList<Integer> rres = path(node.right, x);

        // POST PHASE WORK
        if (rres.size() > 0) {
            rres.add(node.val);
            return rres;
        }

        // keep on returning empty list till node found
        return new ArrayList<>();
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> solve(TreeNode A, int B) {

        ArrayList<Integer> res = path(A, B);
        Collections.reverse(res);

        return res;
    }
}
