// Time Complexity : O(n) where n= number of nodes in a tree
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        
        return isBalanced(root.left) && isBalanced(root.right) && 
        Math.abs(helper(root.left)-helper(root.right))<=1;
    }
    
    public int helper(TreeNode root)
    {
        if(root==null)
            return 0;
        
        return Math.max(helper(root.left),helper(root.right))+1;
    }