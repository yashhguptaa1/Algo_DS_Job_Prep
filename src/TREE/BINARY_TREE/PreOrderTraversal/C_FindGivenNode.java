package TREE.BINARY_TREE.PreOrderTraversal;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

//USES PRINCIPAL OF
// RECURSION.DivideAndConquer.BinarySearch
public class C_FindGivenNode {


    public static boolean find(TreeNode node, int data) {

        //we reach end that is leaf node
        //only when we cannot find the element
        if(node == null) return false;

        if(node.val == data) return true;

         boolean res = false;

         res = find(node.left, data);
         // if we get true from left subtree then
        // || operator
        //would not execute seccond statemment
        //iffirst statement is turue
         res = res || find(node.right, data);

         return res;

    }

    public static boolean findNode(TreeNode node, int data) {

        //we reach end that is leaf node
        //only when we cannot find the element
        if(node == null) return false;

        if(node.val == data) return true;

        boolean lres = findNode(node.left, data);
        if(lres == true) return true;

        boolean rres = findNode(node.right, data);
        if(rres == true) return true;

        return false;
    }

}
