// Time Complexity : O(n)
// Space Complexity : O(height)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


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
    boolean result;
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        result = true;
        helper(root);
        return result;
    }
    
    private int helper(TreeNode root){
        //base
        if(root == null)
            return 0;
        //logic
        //left
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(Math.abs(left - right) > 1){
            result = false;
        }
        
        return Math.max(left, right)+1;
    }
}