// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) where h is the height of the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true; // An empty tree is balanced
        }

        return height(root) != -1; // Check if the tree is balanced
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0; // Height of an empty tree is 0
        }

        int left = height(root.left);
        if (left == -1) {
            return -1; // Left subtree is unbalanced
        }

        int right = height(root.right);
        if (right == -1) {
            return -1; // Right subtree is unbalanced
        }

        int diff = Math.abs(left - right);
        if (diff > 1) {
            return -1; // Difference between left and right heights is more than 1
        }

        return 1 + Math.max(left, right); // Return the height of the current subtree
    }
}
