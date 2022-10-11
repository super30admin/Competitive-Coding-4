/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// TC : O(n)
// SC : O(1)
class Solution {
     boolean isBalanced = true;
    private int helper(TreeNode root) {
        
        if(root == null) return 0;
        
        int l = helper(root.left);
        int r = helper(root.right);
        
        if(Math.abs(l - r) > 1) {
            isBalanced = false;
        }
        
        return Math.max(l, r) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        
        if(root == null) return true;
        
        
        helper(root);
        
        return isBalanced;
    }
    
}
