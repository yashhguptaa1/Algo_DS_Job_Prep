package TREE.BINARY_SEARCH_TREE;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;


public class C_ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] A) {

        return construct(A,0,A.length-1);

    }

    public TreeNode construct (int arr[],int lo,int hi)
    {
        if(lo>hi)
            return null;

        int mid = lo +(hi-lo)/2;

        TreeNode nn = new TreeNode(arr[mid]);

        nn.left = construct(arr,lo,mid-1);
        nn.right = construct(arr,mid+1,hi);

        return nn;
    }
}
