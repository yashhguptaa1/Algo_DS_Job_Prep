package TREE.BINARY_TREE.PostOrderTraversal;


import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT;

import java.util.*;

//Uses RECURSION.Type_R5_Work_PreP_RecCallP_WorkPostP.ReturnType_Arrays_List
public class F_FindPathFromRootToGivenNode {
    public static ArrayList<Integer> nodeToRootPath(A_CreationDisplayBT.TreeNode node, int data) {

        if(node == null) return new ArrayList<>();

        if(node.val == data) {
            ArrayList<Integer> bres = new ArrayList<>();
            bres.add(node.val);
            return bres;
        }

        ArrayList<Integer> lres = nodeToRootPath(node.left, data);
        //This check is to ensure we are storing nodes in path
        //only when we found the node in tree
        //we would keep getting empty arraylist until the node
        //asked is found
        if(lres.size() > 0) {
            lres.add(node.val);
            return lres;
        }

        ArrayList<Integer> rres = nodeToRootPath(node.right, data);
        if(rres.size() > 0) {
            rres.add(node.val);
            return rres;
        }

        return new ArrayList<>();
    }
}
