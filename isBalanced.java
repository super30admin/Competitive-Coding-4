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
    // Time Complexity : O(NlogN)
// Space Complexity : O(height of binary)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1.Check if left and right subtrees height diff is atmost 1 
*/


    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(Math.abs(left-right)<=1 &&  isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
        
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return -1;
        }
        
        int hLeft = helper(root.left);
        int hRight = helper(root.right);
        return 1 + Math.max(hLeft, hRight);
    }
}