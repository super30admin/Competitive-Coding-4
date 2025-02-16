// https://leetcode.com/problems/balanced-binary-tree/

// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, traverse along the tree moving left 1st and right next. Find the height using the condition either root is null then 0, else if left
 * is -1 or right is -1 or |left-right|is -1 return -1. In all other cases return max(left,right)+1 and if value is -1 return false else return 
 * true.
 */

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
        int res = helper(root);
        if(res == -1){
            return false;
        }
        return true;
    }

    private int helper(TreeNode root){
        if(root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == -1 || right == -1 || left-right>1 || right-left>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}