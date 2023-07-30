// Time Complexity : O(n)
// Space Complexity : O(h) for stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

//Solution: Balanced binary tree using DFS
class Solution {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        this.flag = true;
        int result = dfs(root, 0);
        return flag;
    }

    private int dfs(TreeNode root, int level){

        if(root == null) return level;

        int leftDepth = dfs(root.left, level+1);
        int rightDepth = dfs(root.right, level+1);

        int diff = Math.abs(leftDepth - rightDepth);

        if(diff>1) {
            flag = false;
        }

        return Math.max(leftDepth, rightDepth);
    }
}