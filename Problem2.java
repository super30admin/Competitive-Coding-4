//Time = O(n^2), number of nodes
//Space = O(h), height of tree

public class Solution {
    public boolean isBalanced(TreeNode root) {
        // A null tree is considered balanced
        if (root == null) {
            return true;
        }

        // Calculate the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Check if the current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Recursively check if the left and right subtrees are balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // Helper function to calculate the height of a tree
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // The height of a node is 1 plus the maximum height of its left and right subtrees
        return 1 + Math.max(height(node.left), height(node.right));
    }
}