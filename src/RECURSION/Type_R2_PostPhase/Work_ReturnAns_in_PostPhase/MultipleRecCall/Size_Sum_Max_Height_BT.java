package A_recursion.Type_R2_PostPhase.Work_ReturnAns_in_PostPhase.MultipleRecCall;

import java.io.*;
import java.util.*;

public class Size_Sum_Max_Height_BT {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static int size(Node node) {
        if(node == null) return 0;

        int SizeOfLeftBTafterCurrentLevel = size(node.left);
        int SizeOfRightBTafterCurrentLevel = size(node.right);

        int IntermediateResultSoFar= SizeOfLeftBTafterCurrentLevel + SizeOfRightBTafterCurrentLevel;

        //Update IntermediateResultSoFar by adding current node size (which is 1) to it
        int SizeOfCurrentNode =1;
        int updatedAnswer = IntermediateResultSoFar + SizeOfCurrentNode;

        return updatedAnswer;
    }

    // CONSIDERING OUR TREE STARTS FROM TOP TO BOTTOM
    public static int sum(Node node) {
        if(node == null) return 0;

        int SumOfAllNodesInLeftBT = sum(node.left);
        int SumOfAllNodesInRightBT = sum(node.right);

        int SumOfAllNodesBelowCurrLvl= SumOfAllNodesInLeftBT + SumOfAllNodesInRightBT;

        //Update SumSoFar by adding current node value

        int updatedSum = SumOfAllNodesBelowCurrLvl + node.data;

        return updatedSum;
    }

    // CONSIDERING OUR TREE STARTS FROM TOP TO BOTTOM
    public static int max(Node node) {
        if(node == null) return Integer.MIN_VALUE;

        int MaxFromAllNodesInLeftBT = max(node.left);
        int MaxFromAllNodesInRightBT = max(node.right);

        int MaxAllNodesBelowCurrLevel= Math.max(MaxFromAllNodesInLeftBT,MaxFromAllNodesInRightBT);

        //Now compare with Current Node of Current function
        int updatedMax = Math.max(MaxAllNodesBelowCurrLevel , node.data);

        return updatedMax;

    }

    public static int height(Node node) {
        if(node == null) return -1;

        int HeightOfLeftRecursiveTreeDiagram = height(node.left);
        int HeightOfRightRecursiveTreeDiagram = height(node.right);

        return Math.max(HeightOfLeftRecursiveTreeDiagram, HeightOfRightRecursiveTreeDiagram) + 1;
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

        Node root = construct(arr);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

}
