package TREE.Level2;

import java.util.*;

public class q34_allPathsumRoot2Leaf {
    public void pathSum(TreeNode root, int targetSum, int ssf, List<Integer> psf, List<List<Integer>> res) {

        // BC
        if (root == null)
            return;

        // PRE PHASE WORK
        if (root.left == null && root.right == null)// leaf node
        {
            // sum so far + current leaf node.val
            if (ssf + root.val == targetSum) {
                // create a duplicate
                List<Integer> duplicate = new ArrayList<>();
                for (int val : psf)
                    duplicate.add(val);
                // insert root.val in duplicate
                duplicate.add(root.val);
                // add duplicate in res
                res.add(duplicate);
            }
            return;
        }

        // PLACE
        psf.add(root.val);

        // POST RECURSIVE CALLs
        pathSum(root.left, targetSum, ssf + root.val, psf, res);
        pathSum(root.right, targetSum, ssf + root.val, psf, res);

        // UNPLACE
        psf.remove(psf.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subres = new ArrayList<>();
        pathSum(root, targetSum, 0, subres, res);
        return res;
    }
}
