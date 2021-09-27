package TREE.Level2;

public class q35_diameterOfBT {

    // method 3 -> with wrapper class having diameter and height
    // solving two questions at the same time
    public class DiaPair {
        int height;
        int diameter;

        DiaPair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }

        DiaPair() {
            this.height = -1;
            this.diameter = 0;
        }
    }

    public DiaPair diameter3(TreeNode node) {

        // BC
        if (node == null)
            return new DiaPair();

        // PRE RECURSIVE CALLs
        DiaPair lpair = diameter3(node.left);
        DiaPair rpair = diameter3(node.right);

        // POST PHASE WORK
        DiaPair mpair = new DiaPair();

        // find height of tree
        mpair.height = Math.max(lpair.height, rpair.height) + 1;

        // 3 cases
        // max in lst
        // max in rst
        // lst + currnode + rst
        mpair.diameter = Math.max(lpair.height + rpair.height + 2, Math.max(lpair.diameter, rpair.diameter));

        return mpair;
    }
}
