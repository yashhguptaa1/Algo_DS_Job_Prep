package TREE.BINARY_TREE.PostOrderTraversal.Extension_Combination;


import java.util.*;
import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

public class A_AllNodesKlevelsFar {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> res = new ArrayList<Integer>();
        ArrayList<TreeNode> n2rp = path(root,target);

        //To avoid traversing the same nodes again
        TreeNode blockage = null;

        //Start from target node and go up till root node
        for(int i=0;i<n2rp.size() && k>=0;i++)
        {
            TreeNode node = n2rp.get(i);
            ArrayList<Integer> kFar = Klevel(node,blockage,k);
            k--;
            blockage = node;
            res.addAll(kFar);
        }

        return res;
    }

    public ArrayList<TreeNode>path(TreeNode n,TreeNode target)
    {
        //BC
        if(n == null)
            return new ArrayList<>();

        //EC
        if( n == target)
        {
            ArrayList<TreeNode>bres=new ArrayList<>();
            bres.add(n);
            return bres;
        }

        ArrayList<TreeNode>lres=path(n.left,target);
        if(lres.size()>0)
        {
            lres.add(n);
            return lres;
        }

        ArrayList<TreeNode>rres=path(n.right,target);
        if(rres.size()>0)
        {
            rres.add(n);
            return rres;
        }

        //keep on returning empty list till node found
        return new ArrayList<>();
    }


    //Function that returns list of nodes at Kth level from given node
    public ArrayList<Integer> Klevel(TreeNode node, TreeNode blockage, int k)
    {
        //BC
        if(node == null || node== blockage || k<0)
            return new ArrayList<Integer>();

        if( k == 0)
        {
            ArrayList<Integer>bres = new ArrayList<Integer>();
            bres.add(node.val);
            return bres;
        }

        ArrayList<Integer> lres = Klevel(node.left,blockage,k-1);

        ArrayList<Integer> rres = Klevel(node.right,blockage,k-1);

        //Initialize a new arraylist
        ArrayList<Integer>cres = new ArrayList<Integer>();

        //Append results obtained from lst and rst so far
        for(int l:lres)
        {
            cres.add(l);
        }

        for(int r:rres)
        {
            cres.add(r);
        }

        return cres;
    }
}


/*
Difference between
path and kLevel

in path we are updating our list as we make recursive calls

in kLevel we are only getting resultSoFar from recursive call
so we had to make new arraylist to combine the resultSoFar obtained

*/
