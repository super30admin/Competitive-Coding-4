// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    boolean flag;
    int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = 1+helper(root.left);
        int right = 1+helper(root.right);
        if(Math.abs(left-right) > 1)
            flag = false;
        return Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        flag = true;
        helper(root);
        return flag;
    }
}