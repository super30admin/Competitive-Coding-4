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

// Time Complexity: O(n^2) as we are performing n comparisons at each level to check if the tree is balanced
// Space complexity: O(1) no additional data structure used
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach here
// Idea here is to get height of node at each level and check if height of leftmost and rightmost subtree is at most difference of 1.
// we further go to the left and right subtree and again check for height balancing
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(height(root.left)-height(root.right))>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int height(TreeNode root) {
        if(root==null) return 0;
        return Math.max(height(root.left), height(root.right)) +1;
    }
}