// Time Complexity : O(n)
// Space Complexity : O(h) where h = height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Visualising recursion

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
        if (root == null) return true;
        
        if(!isBalanced(root.right) || !isBalanced(root.left))
            return false;
        
        int heightL = helper(root.left);
        int heightR = helper(root.right);
        int diff = Math.abs(heightL-heightR);
        
        if(diff < 2 ){
            return true;
        }else{
            return false;
        }
    }
    
    private int helper(TreeNode root) { // to calculate the height 
        //base
        if(root == null) return 0;
        
        //logic
        int leftH = helper(root.left);
        int rightH = helper(root.right);
        
        return Math.max(leftH,rightH)+1;
    }
}
