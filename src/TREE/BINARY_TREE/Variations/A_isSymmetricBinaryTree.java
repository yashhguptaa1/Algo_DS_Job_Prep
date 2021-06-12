package TREE.BINARY_TREE.Variations;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

import java.util.*;

public class A_isSymmetricBinaryTree {

    public boolean isSymmetric(TreeNode root) {

        boolean ans=false;
        if(root.left ==null && root.right ==null)
            return true;

        return util(root.left,root.right);
    }



    // Trying preorder approach

    public boolean util(TreeNode ptr1,TreeNode ptr2)
    {
        if(ptr1 != null && ptr2 == null)
            return false;

        else if(ptr1 == null && ptr2!=null)
            return false;

        else if(ptr1!=null && ptr2!=null && ptr1.val != ptr2.val)
            return false;

        else if(ptr1 ==null && ptr2==null)
            return true;

        boolean LvsR=util(ptr1.left,ptr2.right);
        boolean RvsL=util(ptr1.right,ptr2.left);

        // if both are null or both have same values
        if(ptr1.val == ptr2.val)
            return LvsR && RvsL && true;


        return LvsR && RvsL;
    }

    // SHORTHAND VERSION

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }


    //Iterative version

    public boolean isSymmetricItr(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }


}
