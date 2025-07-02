//Time Complexity: O(n)
//Space Complexity: O(h)

/**
 * Checks if a binary tree is balanced, where the height difference between left and right subtrees shoulbe be1.
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
