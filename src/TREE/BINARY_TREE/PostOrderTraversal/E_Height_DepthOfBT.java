package TREE.BINARY_TREE.PostOrderTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;
import static TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.construct;

public class E_Height_DepthOfBT {

    // Considering Leaf Node is at height 0
    // Or we can say Root Node is at Level 0
    // The null node will be at height -1
    // change base case to return -1

    // return the height of tree in terms of edges
    // For N=2 edges=1
    // BC : For N=0 => N = 2-2 = 0
    // Edges = 1-2 = -1
    public static int height(TreeNode node) {
        if (node == null)
            return -1;

        int LevelsInLeftBTafterCurrNode = height(node.left);
        int LevelsInRightBTafterCurrNode = height(node.right);

        int maxNumberOfLvlsAfterCurrNode = Math.max(LevelsInLeftBTafterCurrNode, LevelsInRightBTafterCurrNode);

        // from whichever side we get maximum Height
        // add currnode to that side to update
        // resultant Height
        return maxNumberOfLvlsAfterCurrNode + 1;
    }

    // RECURSION.Type_R2_PostOrder_Rec_Call.Work_ReturnAns_in_PostPhase
    public int maxDepth(TreeNode root) {

        // as count of Leaf node = 1
        // It is at depth 1
        // so null nodes will be at depth 0
        if (root == null) {
            return 0;
        }

        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);

        int maxDepthSoFar = Math.max(ldepth, rdepth);
        int currNodeDepth = 1;// current node count

        return maxDepthSoFar + currNodeDepth;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        TreeNode root = construct(arr);

        int height = height(root);
        System.out.println(height);

    }
}
/*
 * 104. Maximum Depth of Binary Tree Easy
 * 
 * 
 * Given the root of a binary tree, return its maximum depth.
 * 
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: 3 Example 2:
 * 
 * Input: root = [1,null,2] Output: 2 Example 3:
 * 
 * Input: root = [] Output: 0 Example 4:
 * 
 * Input: root = [0] Output: 1
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 104]. -100 <= Node.val <=
 * 100
 * 
 * 
 * 19 50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
 */