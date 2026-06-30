// Time Complexity : O(n)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : Yes

// - Perform a postorder traversal so the heights of the left and right subtrees are computed before processing the current node.
// - At each node, compare the heights of its left and right subtrees. If the difference is greater than 1, mark the tree as unbalanced.
// - Return the height of the current subtree as 1 + max(leftHeight, rightHeight) so parent nodes can perform the same balance check.

class BalancedBinaryTree {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);

        return isBalanced;
    }

    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}