package TREE.BINARY_TREE.PostOrderTraversal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;
import static TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.construct;

public class E_Height_DepthOfBT {


    //Considering Leaf Node is at height 0
    //If Given that Leaf Node is at level 1 then find levels then
    //change base case to return 0
    public static int height(TreeNode node) {
        if(node == null) return -1;

        int LevelsInLeftBTafterCurrNode = height(node.left);
        int LevelsInRightBTafterCurrNode = height(node.right);

        int maxNumberOfLvlsAfterCurrNode = Math.max(LevelsInLeftBTafterCurrNode,LevelsInRightBTafterCurrNode);

        //from whichever side we get maximum depth add currnode to that side to update
        //resultant depth
        return maxNumberOfLvlsAfterCurrNode + 1;
    }

    // using Recursion.Type R3.P2
    public int maxDepth(TreeNode root) {

        // as Leaf node is at depth 1
        //so null nodes will be at depth 0
        if(root == null)
        {
            return 0;
        }

        int ldepth = maxDepth(root.left);
        int rdepth=maxDepth(root.right);

        int maxDepthSoFar=Math.max(ldepth,rdepth);
        int currNodeDepth =1;

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
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n

Sample Output
9
448
87
3

 */