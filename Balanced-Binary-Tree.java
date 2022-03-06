// Time Complexity : O(n) where n is number of nodes
// Space Complexity : O(h) where h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach :
// Recursive approach where we calculate height
// If height difference(absolute) between left and right subtree is > 1, not balanced
// Height at any node returned as max(left, right) + 1


class Solution {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isBalanced(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        
        if (height(root) == -1) {
            return false;
        }
        return true;
    }
    
    private int height(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        
        if (left == -1 || right == -1) {
            return -1;
        }
        
        return (Math.max(left, right)) + 1;
    }
}