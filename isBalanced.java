// Time Complexity : O(n) n is number of nodes
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        boolean leftBal = isBalanced(root.left);
        boolean rightBal = isBalanced(root.right);
        int h = Math.abs(height(root.left)-height(root.right));
        return (leftBal && rightBal && (h<=1));
        
    }
    
    private int height(TreeNode root)
    {
        if(root==null) return 0;
        return Math.max(height(root.left) , height(root.right))+1;
    }
}