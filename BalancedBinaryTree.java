// Time Complexity : O(n) --> where n is number of nodes in the tree
// Space Complexity : O(h) --> where h is the height of the tree
// Did this code successfully run on Leetcode (110): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    boolean result;
    public boolean isBalanced(TreeNode root) {
        result = true;
        if (root == null) return true;
        helper(root);
        return result;
    }
    private int helper(TreeNode root) {
        if(root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        
        if (Math.abs(left - right) > 1) result = false;
        return Math.max(left, right) + 1; 
    }
}