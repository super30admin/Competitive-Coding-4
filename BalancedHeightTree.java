/*
Time Complexity: O(n) where n is the number of nodes in the tree.
Space Complexity: O(h) where h is the height of the tree due to recursion stack.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Intuition: The idea is to check the height of the left and right subtrees of each node.
*/

public class BalancedHeightTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        // checking height of entire tree as a whole
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        // checking height of each subtree
        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}