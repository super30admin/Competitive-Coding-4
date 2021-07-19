// 110. Balanced Binary Tree - https://leetcode.com/problems/balanced-binary-tree/
// Time Complexity : O(N)
// Space Complexity : O(1)
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
// Bottom up approach
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        return height(root) != -1;
    }
    
    public int height(TreeNode node){
        if(node == null) return 0;
        
        int left = height(node.left);
        int right = height(node.right);
        int bf = Math.abs(left-right);
        
        if(bf>1 || left == -1 || right == -1) return -1;
        
        return 1 + Math.max(left,right);
        
    }
}