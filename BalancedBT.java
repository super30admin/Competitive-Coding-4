// TC - O(n)
// SC - O(1)
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
class Solution {
    boolean flag;

    public boolean isBalanced(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }

    private int helper(TreeNode node) {
        // Base
        if (node == null)
            return 0;

        // Logic
        if (node.left == null && node.right == null)
            return 1;

        // Left
        int leftHeight = 1 + helper(node.left); // Increment height by 1 and get the height of left subtree

        // Right
        int rightHeight = 1 + helper(node.right); // Increment height by 1 and get the height of right subtree

        int diff = Math.abs(leftHeight - rightHeight); // Check if the diff is greater of 1
        if (diff > 1) {
            flag = false;
        }

        return Math.max(leftHeight, rightHeight); // Return max height of left and right sub tree height

    }
}