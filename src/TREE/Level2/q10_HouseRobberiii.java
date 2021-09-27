package TREE.Level2;

public class q10_HouseRobberiii {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public class RPair {
        int withRob;
        int withoutRob;

        public RPair(int withRob, int withoutRob) {
            this.withRob = withRob;
            this.withoutRob = withoutRob;
        }
    }

    public RPair robberyInHouse(TreeNode node) {
        if(node == null) {
            return new RPair(0, 0);
        }

        RPair left = robberyInHouse(node.left);
        RPair right = robberyInHouse(node.right);

        int a = left.withRob;
        int a_ = right.withRob;
        int b = left.withoutRob;
        int b_ = right.withoutRob;
        int c = node.val;

        // robbery (Done) at current node: (b + b') + c
        // without robbery -> (a + a') vs. (a + b') vs. (a' + b) vs (b + b')
        int withRob = b + b_ + c;
        // int withoutRob = Math.max(Math.max(a + a_, a + b_), Math.max(a_ + b, b + b_));
        // OR
        int withoutRob = Math.max(a,b) + Math.max(a_, b_);

        return new RPair(withRob, withoutRob);
    }

    public int rob(TreeNode root) {
        RPair res = robberyInHouse(root);
        return Math.max(res.withRob, res.withoutRob);
    }
    
}
