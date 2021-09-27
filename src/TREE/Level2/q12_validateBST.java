package TREE.Level2;

public class q12_validateBST {
    class BSTPair{
        boolean isBst;
        long min;
        long max;
    }
    
    
    public BSTPair isBST(TreeNode node)
    {
        if(node == null)
        {
            BSTPair bp = new BSTPair();
            bp.min = Long.MAX_VALUE;
            bp.max = Long.MIN_VALUE;
            bp.isBst = true;
            return bp;
        }
        
        BSTPair lp = isBST(node.left);
        BSTPair rp = isBST(node.right);
        
        BSTPair mp=new BSTPair();
        
        mp.isBst = lp.isBst && rp.isBst &&
                    (node.val > lp.max && node.val < rp.min);
        
        mp.min=Math.min(node.val,Math.min(lp.min,rp.min));
        mp.max=Math.max(node.val,Math.max(lp.max,rp.max));
        
        return mp;
        
    }
    
    public boolean isValidBST(TreeNode root) {
        
        BSTPair res = isBST(root);

        return res.isBst;
    }

    //submission 2
    // public boolean isValidBST(TreeNode root) {
    //     return isBSTUtil(root, Long.MIN_VALUE,
    //                            Long.MAX_VALUE);
        
    // }
    
    public boolean isBSTUtil(TreeNode node, long min, long max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;
 
        /* false if this node violates the min/max constraints */
        if (node.val < min || node.val > max)
            return false;
 
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min,(long) node.val-1) &&
                isBSTUtil(node.right,(long) node.val+1, max));
    }

}
