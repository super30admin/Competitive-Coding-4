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
// Approach: Recursively compute subtree heights while checking balance
// Time: O(N)
// Space: O(h) due to recursion stack
class Solution {
    boolean isBalancedTree;
    public boolean isBalanced(TreeNode root) {
        this.isBalancedTree = true;
        computeHeightAndCheckBalance(root);
        return this.isBalancedTree;
    }

    private int computeHeightAndCheckBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if (this.isBalancedTree) {
            // Height of left subtree including current node
            leftHeight = computeHeightAndCheckBalance(root.left) + 1;
        }
        if (this.isBalancedTree) {
            // Height of right subtree including current node
            rightHeight = computeHeightAndCheckBalance(root.right) + 1;
        }
        // Check balance condition at current node
        if (Math.abs(leftHeight - rightHeight) > 1) {
            // Mark tree as unbalanced
            this.isBalancedTree = false;
        }
        // Return height of current subtree
        return Math.max(leftHeight, rightHeight);
    }
}