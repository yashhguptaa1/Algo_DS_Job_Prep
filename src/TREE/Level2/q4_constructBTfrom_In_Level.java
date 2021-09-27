package TREE.Level2;

import java.util.*;

public class q4_constructBTfrom_In_Level {

    public static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int inord[] = new int[n];
            int level[] = new int[n];
            for (int i = 0; i < n; i++)
                inord[i] = sc.nextInt();

            for (int i = 0; i < n; i++)
                level[i] = sc.nextInt();

            Node node = buildTree(inord, level);
            printPreOrder(node);
            System.out.println();

        }
        sc.close();
    }

    public static void printPreOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static Node constructInLevel(int[] in, ArrayList<Integer> lvlOrder, int inSt, int inEnd) {

        // BC
        if (lvlOrder.size() == 0)
            return null;

        // LEVEL : denoted by each root node
        // root: current root node
        Node root = new Node(lvlOrder.get(0));

        // indx: to traverse on indorder and get index of current root node
        int indx = inSt;

        // set: to store nodes present in left subtree obtained from inorder traversal
        HashSet<Integer> set = new HashSet<>();
        while (in[indx] != lvlOrder.get(0)) {
            set.add(in[indx]);
            indx++;
        }

        // llvl: to store nodes in left subtree for level order traversal
        ArrayList<Integer> llvl = new ArrayList<>();

        // rlvl: to store nodes in right subtree for level order traversal
        ArrayList<Integer> rlvl = new ArrayList<>();

        // segregating nodes from level order traversal into LST and RST
        for (int i = 1; i < lvlOrder.size(); i++) {
            int val = lvlOrder.get(i);
            if (set.contains(val)) {
                llvl.add(val);
            } else {
                rlvl.add(val);
            }
        }

        // POSTORDER RECURSIVE CALL
        // 2 OPTIONS : i) lst ii) rst

        // since indx points to root node

        // UPDATED inEnd : nodes on left of indx are in LST
        root.left = constructInLevel(in, llvl, inSt, indx - 1);

        // UPDATED inSt : nodes on right of indx are in RST
        root.right = constructInLevel(in, rlvl, indx + 1, inEnd);

        return root;
    }

    public static Node buildTree(int inord[], int lvl[]) {
        ArrayList<Integer> level = new ArrayList<>();
        for (int val : lvl)
            level.add(val);
        
        return constructInLevel(inord, level, 0, inord.length - 1);
    }
}
