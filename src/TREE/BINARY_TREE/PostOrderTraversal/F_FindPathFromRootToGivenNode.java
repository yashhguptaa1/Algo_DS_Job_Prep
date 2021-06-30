package TREE.BINARY_TREE.PostOrderTraversal;


import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;

import java.util.*;

//It is similar/ extension to problem PRINT ZIG ZAG in recursion
//Return Ans In PrePhase
//Left Recursive call
//Work in Inphase : as you go back on the path which you cam from
//Right Recursive call
// Work in PostPhase : as you go back on the path which you cam from
//Return

public class F_FindPathFromRootToGivenNode {
    public static ArrayList<Integer> nodeToRootPath(TreeNode node, int data) {

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
/*
Problem Description

Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B.

NOTE:

No two nodes in the tree have same data values.
You can assume that B is present in the tree A and a path always exists.


Problem Constraints
1 <= N <= 105

1 <= Data Values of Each Node <= N

1 <= B <= N



Input Format
First Argument represents pointer to the root of binary tree A.

Second Argument is an integer B denoting the node number.



Output Format
Return an one-dimensional array denoting the path from Root to the node B in order.



Example Input
Input 1:

 A =

           1
         /   \
        2     3
       / \   / \
      4   5 6   7


B = 5

Input 2:

 A =
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6


B = 1




Example Output
Output 1:

 [1, 2, 5]
Output 2:

 [1]


Example Explanation
Explanation 1:

 We need to find the path from root node to node with data value 5.
 So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]
Explanation 2:

 We need to find the path from root node to node with data value 1.
 As node with data value 1 is the root so there is only one node in the path.
 So we will return [1]


 */