// Bottom-up dfs

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : level1 == -1 || level2 == -1 and return Math.max(level1, level2)+1; are the two things that I was not able to come up on my own.

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(dfs(root) != -1)
            return true;
        else
            return false;
    }
    
    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        
        int level1 = dfs(root.left);
        int level2 = dfs(root.right);
        if(Math.abs(level1 - level2) > 1 || level1 == -1 || level2 == -1)
            return -1;
        else
            return Math.max(level1, level2)+1;
    }
}
