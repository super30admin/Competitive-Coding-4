// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

/*
 * Do a DFS to get the height on either side. The height is given by
 * 1 + max(height of left subtree, height of right subtree)
 * Null trees have height 0.
 * If at any point the height difference between left and right > 1,
 * set the result to false.
 */
public class BalancedBinaryTree {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    boolean result;

    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        result = true;
        getHeight(root);
        return result;
    }

}
