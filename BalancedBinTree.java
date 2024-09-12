// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    
    boolean isBalancedTree = true;
    
    public boolean isBalanced(TreeNode root) {
        // base check
        if (root == null) return true;
        
        helper(root);
        
        return isBalancedTree;
    }
    
    private int helper(TreeNode root) {
        // base case
        if (root == null) return 0;
        
        // Logic
        int left = helper(root.left);
        int right = helper(root.right);
        
        if (Math.abs(left - right) > 1)
            isBalancedTree = false;
        
        return Math.max(left, right) + 1;
    }
}