// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes in understanding the balanced binary tree

class Solution {
    public boolean isBalanced(TreeNode root) {
       if(helper(root) != -1) return true;
        return false;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        if(left == -1) return -1;
        int right = helper(root.right);
        if(left == -1 || right == -1) return -1;
        int diff = Math.abs(left - right);
        if(diff > 1) return - 1;
        return Math.max(left, right)+ 1;
    }
}