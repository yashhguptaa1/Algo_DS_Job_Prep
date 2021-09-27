package INTERVIEWBIT.TREES.P1_PreWork_PostCall.DivideAndConquer;

public class constructBTfrom_Post_In {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;

        return constructPostIn(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode constructPostIn(int[] post, int[] in, int poSt, int poEnd, int inSt, int inEnd) {

        // BC : for creation of NULL nodes, children of LEAF
        if (poSt > poEnd)
            return null;

        // PRE PHASE WORK

        // DIVIDING FACTOR : root node of respective subtree
        TreeNode root = new TreeNode(post[poEnd]);

        // find presence of root node in inorder with indexVariable indx
        int indx = inSt;
        while (in[indx] != post[poEnd])
            indx++;

        // get all elements present in leftsubtree
        int elementCount = indx - inSt;

        // POST RECURSIVE CALLs : CONQUERING lst and rst

        // Updated members to be passed in LEVEL recursive call
        // poEnd : all nodes in LST of curr root node excluding root node
        // : so for next call => poSt + elementCount - 1
        // inEnd : Element at indx in inorder array is the current root node
        // : so for next call => indx-1
        root.left = constructPostIn(post, in, poSt, poSt + elementCount - 1, inSt, indx - 1);

        // poEnd : Element at poEnd in postorder array is the current root node
        // : so for next call => poEnd-1
        root.right = constructPostIn(post, in, poSt + elementCount, poEnd - 1, indx + 1, inEnd);

        return root;
    }
}
