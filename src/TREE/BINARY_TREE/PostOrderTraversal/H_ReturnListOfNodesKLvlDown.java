package TREE.BINARY_TREE.PostOrderTraversal;

import TREE.BINARY_TREE.PreOrderTraversal.A_CreationDisplayBT.TreeNode;
import java.util.*;

public class H_ReturnListOfNodesKLvlDown {

    //USING THE PRINCIPLE OF
    //FIRST CODE WHAT YOU KNOW (your existing knowledge)

    //THEN COMPARE THE NEW THING TO IMPLEMENT HERE
    //Basically now i have two options
    //work in pre phase
    // work in post phase

    // i must work in post phase
    //cauz i want to traverse all nodes and then exit from root node
    //But since i dont want to traverse nodes after i hit the given level
    //I must stop my recursion in prephase as soonas i meet the level

    //USES RECURSION.Type_R3_PrePhase_RecCallPhase_PostPhase.SingleRecCall.ReturnType_Arrays_List;

        ArrayList<Integer> Kdistance(TreeNode node, int k)
        {

            //BC
            if(node == null)
                return new ArrayList<Integer>();

            if( k == 0)
            {
                ArrayList<Integer>bres = new ArrayList<Integer>();
                bres.add(node.val);
                return bres;
            }

            ArrayList<Integer> lres = Kdistance(node.left,k-1);

            ArrayList<Integer> rres = Kdistance(node.right,k-1);

            ArrayList<Integer>cres = new ArrayList<Integer>();


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
K distance from root

Given a Binary Tree of size N and an integer K. Return a list all nodes that are at distance k from root
 (root is considered at distance 0 from itself). Nodes should be printed from left to right.
 If k is more that height of tree, nothing should be printed.

For example, if below is given tree and k is 2. Output should be 4 5 6.

          1
       /     \
     2        3
   /         /   \
  4        5    6
     \
      8

Example 1:

Input:
K = 0
      1
    /   \
   3     2
Output: 1

Example 2:

Input:
K = 3
        3
       /
      2
       \
        1
      /  \
     5    3
Output: 5 3
Your Task:
You don't have to take input. Complete the function Kdistance() that accepts root node and k as parameter and return the value of the nodes that are at a distance k from the root. (The values are returned as vector in cpp, as ArrayList in java and list in python)
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= N <= 104
0 <= K <= 30

 */