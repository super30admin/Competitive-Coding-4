/*
 * Time Complexity: O(N) where N is the number of nodes in the Binary Tree.

Space Complexity: O(1) as no additional data structures or memory is allocated.
 */


 class Solution {
    public boolean isBalanced(TreeNode root) {
        // Call the recursive helper method to check balance status.
        // If the heightDifference() returns -1, the tree is unbalanced.
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        // Base case: If the current node is null, the height of an empty tree is 0.
        if (root == null) return 0;

        // Recursively calculate the height of the left subtree.
        int leftHeight = dfsHeight(root.left);
        // If the left subtree is unbalanced, propagate the unbalance status.
        if (leftHeight == -1) return -1;

        // Recursively calculate the height of the right subtree.
        int rightHeight = dfsHeight(root.right);
        // If the right subtree is unbalanced, propagate the unbalance status.
        if (rightHeight == -1) return -1;

        // Check if the difference in height between the left and right subtrees is greater than 1.
        // If the difference is greater, the tree is unbalanced.
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        // Return the height of the tree rooted at the current node.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}