package INTERVIEWBIT.TREES.P1_PreWork_PostCall;

import INTERVIEWBIT.TREES.TreeNode;

public class PathSum {

    class Solution {
        public int hasPathSum(TreeNode A, int B) {
            
            boolean ans=hasPath(A,0,B);
            
            return ans ? 1 : 0;
        }
        
        //We use PreOrder Traversal cauz we want to return the answer as soon as we find it
        //we dont have to traverse all nodes or no need to exit at root
        //we exit when we get leaf node
        //So postorder traversal is pointless
        
        public boolean hasPath(TreeNode node,int sumSoFar,int t)
        {
            // BC : no node
            if(node == null)
                return false;
                
            //PRE PHASE WORK
            //if reached a leaf node
            if(node.left == null && node.right == null)
            {
                //add leaf node value to sumSoFar
                sumSoFar += node.val;
                if(sumSoFar == t)
                {
                    return true;
                }
            }
            
            //POST RECURSIVE CALLS
            boolean lres=hasPath(node.left,sumSoFar + node.val,t);
            boolean rres=hasPath(node.right,sumSoFar + node.val,t);
            
            return lres || rres;
        }
        
        // private boolean hasPath(TreeNode node, int sumc)
        // {
        //     if (node == null)
        //         return false;
                
        //     if (node.left == null && node.right == null && sumc == node.val)
        //         return true;
                
        //     return hasPath(node.left, sumc-node.val)||hasPath(node.right,sumc-node.val);
        // }
    }
    
}
