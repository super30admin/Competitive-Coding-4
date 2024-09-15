/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return height(root) != -1;

    }

    // Bottom up Approach
    private int height(TreeNode root) {
        // base
        if (root == null)
            return 0;
        // logic
        int left = height(root.left); // finding height of left child
        int right = height(root.right); // finding height of right child
        if (Math.abs(left - right) > 1)
            return -1; // if diff is >1, then return -1 to parent to indicate not balanced.
        if (left == -1 || right == -1)
            return -1; // if either left or right is -1, not balanced
        return Math.max(left, right) + 1; // else return the (max height between left and right) +1 to parent

    }
}