// TIME: O(n)
// SPACE: O(h) where h = height of the tree
// SUCCESS on LeetCode

public class IsBalancedBT {
    private boolean balanced;
    public boolean isBalanced(TreeNode root) {
        balanced = true;
        helper(root);
        return balanced;
    }
    
    private int helper(TreeNode node) {
        if (node == null) return -1;
        if (node.left == null && node.right == null) return 0;
        int leftHeight = helper(node.left);
        int rightHeight = helper(node.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            balanced = false;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
