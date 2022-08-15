// Time Complexity : O(n)
// Space Complexity : O(h)
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
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return flag;
    }
    
    private int helper(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
        if(!flag) {
            return -1;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(right - left) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}