// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return result;
    }
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        if(result == false)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);

        if(Math.abs(l - r) > 1){
            result = false;
        }
        return Math.max(l, r) + 1;
    }
}
