package TREE.Level2;

public class q13_RecoverBST {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // pointers[0] -> prev : to track first swapped element
    // pointers[1] -> curr : to track second swapped element
    // pointers[2] -> a : stores the first swapped element
    // pointers[3] -> b : stores the second swapped element
    public void recover_Tree(TreeNode currNode, TreeNode[] pointers) {
        if(currNode == null) return;

        recover_Tree(currNode.left, pointers);

        //for the first time 
        //prev -> null
        if(pointers[0] == null) {
            pointers[0] = currNode;
        } else {

            //move curr pointer
            pointers[1] = currNode;
            if(pointers[0].val > pointers[1].val) {
                // prev > curr
                if(pointers[3] == null) {
                    // first encounter
                    //b -> null
                    pointers[2] = pointers[0];
                    pointers[3] = pointers[1];
                } else {
                    // second encounter
                    pointers[3] = currNode;
                }
            }
            // move prev pointer
            pointers[0] = currNode;
        }
        recover_Tree(currNode.right, pointers);
    }

    public void recoverTree(TreeNode root) {
        TreeNode[] pointers = new TreeNode[4];
        recover_Tree(root, pointers);
        // swap value for a and b, i.e. pointers[2], pointers[3]
        int temp = pointers[2].val;
        pointers[2].val = pointers[3].val;
        pointers[3].val = temp;
    }
}
