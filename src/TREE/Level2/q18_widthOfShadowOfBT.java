package TREE.Level2;

public class q18_widthOfShadowOfBT {
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
}
