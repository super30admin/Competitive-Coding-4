// Time Complexity :  O(n)
// Space Complexity : O(h) (h - height of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

public class BalancedBinartTree {
    boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        helper(root);
        return isBalanced;
    }

    private int helper(TreeNode root){
        if (root == null) return 0;

        int l = helper(root.left);
        int r = helper(root.right);
        if (Math.abs(l-r) > 1) isBalanced = false;

        return Math.max(l,r)+1;
    }
}