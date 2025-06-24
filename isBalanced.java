// Time Complexity: O(n) 
// Space Complexity: O(h) 
// h = height of tree, n - no. of nodes
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
    // Method to check if a binary tree is balanced
    public boolean isBalanced(TreeNode root) {
        // If the tree is empty, it is balanced
        if (root == null) return true;
        // Use helper method to check balance and return true if the result is not -1
        return helper(root) != -1;
    }

    // Helper method to check the balance of the tree and return the height
    private int helper(TreeNode root) {
        // Base case: if null) return 0;

        // Recursively get the height of the left subtree
        int left = helper(root.left);
        // Recursively get the height of the right subtree
        int right = helper(root.right);

        // If the difference in heights is greater than 1, return -1 indicating imbalance
        if (Math.abs(left - right) > 1) return -1;
        // If either subtree is imbalanced, propagate the -1 upwards
        if (left == -1 || right == -1) return -1;

        // Return the height of the current node
        return Math.max(left, right) + 1;
    }
}
