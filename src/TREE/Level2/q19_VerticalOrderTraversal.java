package TREE.Level2;

import java.util.*;

public class q19_VerticalOrderTraversal {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Width of shadow of binary tree
    static int lh = 0; // find min in left horizontal
    static int rh = 0; // find max in right horizontal

    private static void width(TreeNode root, int count) {
        if(root == null) return;

        if(count < lh) {
            lh = count;
        } else if(count > rh) {
            rh = count;
        }

        width(root.left, count - 1);
        width(root.right, count + 1);
    }

    public static int width(TreeNode root) {
        if(root == null) return 0;
        lh = 0;
        rh = 0;
        width(root, 0);
        return rh - lh + 1;
    }


    // vertical order traversal - I
    // https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
    static class Pair implements Comparable<Pair>{
        TreeNode node;
        int count;

        public Pair(TreeNode node, int count) {
            this.node = node;
            this.count = count;
        } 

        public int compareTo(Pair o) {
            return this.node.val - o.node.val;
        }
    }

    static ArrayList<Integer> verticalOrder(TreeNode root) {
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root, 0));
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

        int lh = 0; // left horizontal
        int rh = 0; // right horizontal 
        while(qu.size() > 0) {
            // 1. get + remove
            Pair rem = qu.remove();
            // 2. work
            if(map.containsKey(rem.count)) {
                map.get(rem.count).add(rem.node.val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(rem.node.val);
                map.put(rem.count, list);
            }
            if(rem.count < lh) {
                lh = rem.count;
            } else if(rh < rem.count) {
                rh = rem.count;
            }
            // 3. add children
            if(rem.node.left != null) {
                qu.add(new Pair(rem.node.left, rem.count - 1));
            }
            if(rem.node.right != null) {
                qu.add(new Pair(rem.node.right, rem.count + 1));
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = lh; i <= rh; i++) {
            for(int val : map.get(i)) {
                res.add(val);
            }
        }
        return res;
    }

    // method 2 without hashmap
    public static ArrayList<ArrayList<Integer>> verticalOrder2(TreeNode root) {
        lh = 0;
        rh = 0;
        int wd = width(root);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i < wd; i++)
            res.add(new ArrayList<>());

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root, Math.abs(lh)));

        while(qu.size() > 0) {
            // 1. get + remove
            Pair rem = qu.remove();
            // 2. work
            res.get(rem.count).add(rem.node.val);
            // 3. add children
            if(rem.node.left != null) {
                qu.add(new Pair(rem.node.left, rem.count - 1));
            }
            if(rem.node.right != null) {
                qu.add(new Pair(rem.node.right, rem.count + 1));
            }
        }
        return res;
    }
    
}
