
// Time Com: O(h)
// Space Com: O(n)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

class Solution {
    public boolean isBalanced(TreeNode root) {
        // null case
        if(root == null){
            return true;
        }
        
        int result = helper(root);
        
        return result != -1;
    }
    
    private int helper(TreeNode root) {
        //Basic
        if(root == null){
            return 0;
        }
        
        int left = helper(root.left);
        
        int right = helper(root.right);
        
        
        // Logic
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        
        return Math.max(left + 1, right + 1);
    }
}