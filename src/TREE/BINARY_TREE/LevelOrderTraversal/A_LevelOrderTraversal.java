package TREE.BINARY_TREE.LevelOrderTraversal;


import java.util.*;
import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;


public class A_LevelOrderTraversal {

//Follows the concept of Queue : RPA
//Remove a single Node from queue that belongs to current level and store in temp
//Print this temp
//Add data related (children ofNode) to this temp( IF ANY) in queue


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        //If given tree is empty
        if(root == null )
            return res;

        //add in back
        //remove from front
        Queue<TreeNode>lvlorder = new ArrayDeque<>();
        lvlorder.add(root);

        //Still elements left to be processed
        while(lvlorder.size()>0)
        {
            //Get size of current lvl of tree
            int sz=lvlorder.size();

            //Print/Store nodes of current level
            List<Integer>currLvl=new ArrayList<>();

            while(sz-- > 0)
            {
                // 1. get + remove
                TreeNode currNode = lvlorder.remove();

                // 2. print or store
                currLvl.add(currNode.val);

                // 3. add children
                //and sath sath insert children of each node in queue
                if(currNode.left != null)
                    lvlorder.add(currNode.left);

                if(currNode.right != null)
                    lvlorder.add(currNode.right);

            }

            //add all nodes obtained in current level to resultant list
            res.add(currLvl);

        }

        return res;
    }
}
