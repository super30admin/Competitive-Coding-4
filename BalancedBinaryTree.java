/**
 * TC - O(n) where n is total number of nodes
 * SC - O(h) where h is height of the tree
 */
public class BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        getHeight(root);
        return result;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left) + 1;
        int rightHeight = getHeight(root.right) + 1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
        }

        return Math.max(leftHeight, rightHeight);
    }
}
