/**
 * Time Complexity (TC): O(n) - n is no.of nodes of the Tree
 * Space Complexity (SC): O(h) - height of the binary tree
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return heightCalculate(root) != -1;
    }

    private int heightCalculate(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = heightCalculate(node.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = heightCalculate(node.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
