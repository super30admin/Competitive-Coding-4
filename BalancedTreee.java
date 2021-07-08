// Time Complexity : O(NlogN)
// Space Complexity : O(N)

// We perform DFS on left and right child of the node
// While retrning back we check if difference between left and right height is greater than one.
// If yes then we mark result false and in subsequent dfs we don't proceed as result is already false
class Solution1 {
    boolean result;

    public boolean isBalanced(TreeNode root) {
        result = true;
        if (root != null) {
            helper(root);
        }
        return result;
    }

    private int helper(TreeNode node) {
        // base
        if (node == null || !result)
            return 0;

        // logic
        int leftHeight = helper(node.left);
        int rightHeight = helper(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}