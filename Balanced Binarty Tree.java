// Time Complexity : O(n) where n = no. of nodes
// Space Complexity : O(h) where h = height of the tree
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
        if(root == null)    return true;
        
        return (calcHeight(root) != -1);
    }
    
    private int calcHeight(TreeNode root){
        // base case
            if(root == null)    return 0;
        
        // logic
        int leftHeight = calcHeight(root.left);
        
        int rightHeight = calcHeight(root.right);
        
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(rightHeight - leftHeight) > 1){
            return -1;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
        
    }
}