package TREE.BINARY_TREE.LevelOrderTraversal;

import java.util.*;
import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class A_LevelOrderTraversal {

    // Follows the concept of Queue : RPA
    // Remove a single Node from queue that belongs to current level and store in
    // temp
    // Print this temp
    // Add data related (children ofNode) to this temp( IF ANY) in queue

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        // If given tree is empty
        if (root == null)
            return res;

        // add in back
        // remove from front
        Queue<TreeNode> lvlorder = new ArrayDeque<>();
        lvlorder.add(root);

        // Still elements left to be processed
        while (lvlorder.size() > 0) {
            // Get size of current lvl of tree
            int sz = lvlorder.size();

            // Print/Store nodes of current level
            List<Integer> currLvl = new ArrayList<>();

            while (sz-- > 0) {
                // 1. get + remove
                TreeNode currNode = lvlorder.remove();

                // 2. print or store
                currLvl.add(currNode.val);

                // 3. add children
                // and sath sath insert children of each node in queue
                if (currNode.left != null)
                    lvlorder.add(currNode.left);

                if (currNode.right != null)
                    lvlorder.add(currNode.right);

            }

            // add all nodes obtained in current level to resultant list
            res.add(currLvl);

        }

        return res;
    }
}

/*
 * 102. Binary Tree Level Order Traversal Medium
 * 
 * 4988
 * 
 * 109
 * 
 * Add to List
 * 
 * Share Given the root of a binary tree, return the level order traversal of
 * its nodes' values. (i.e., from left to right, level by level).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: [[3],[9,20],[15,7]] Example 2:
 * 
 * Input: root = [1] Output: [[1]] Example 3:
 * 
 * Input: root = [] Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 2000]. -1000 <= Node.val
 * <= 1000
 */