
// Time Complexity : O(n)
// Space Complexity :O(d) where d  is the depth of the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
     public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int height = helper(root, 0);
        if(height == Integer.MAX_VALUE) return false;
        else return true;   
    }
    private int helper(TreeNode root, int level)
    {
        if(root==null) return level;
        
        int left = helper(root.left, level+1);
        int right = helper(root.right, level+1);
        int diff = Math.abs(left-right);
        if(diff<2) return Math.max(left,right);
        else return Integer.MAX_VALUE;
        
    }
}