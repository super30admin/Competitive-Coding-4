//Time Complexity: O(n) where n is the number of nodes in the tree
//Space Complexity: O(h) where h is the height of the tree due to recursion stack

/**
 * Checks if a binary tree is balanced, where the height difference between left and right subtrees is at most 1.
 * Uses a helper function to recursively calculate the height of subtrees and check for balance.
 * Returns false if any subtree is unbalanced, otherwise returns true.
 */

public class BalancedBinaryTree{
    public boolean isBalanced(TreeNode root) {
        int heightDiff = helper(root);

        if (heightDiff == -1)
            return false;
        return true;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);

    if (Math.abs(leftHeight - rightHeight) > 1 || leftHeight == -1 || rightHeight == -1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;

    }
}class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
