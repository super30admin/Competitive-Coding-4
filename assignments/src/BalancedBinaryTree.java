// Approach: Bottom-up recursion. Check if the child subtrees are balanced. If they are, use their
// heights to determine if the current subtree is balanced as well as to calculate the current
// subtree's height.
// Time: O(n)
// Space: O(n)
final class TreeInfo {
    public final int height;
    public final boolean balanced;

    public TreeInfo(int height, boolean balanced) {
        this.height = height;
        this.balanced = balanced;
    }
}

class BalancedBinaryTree {
    private TreeInfo isBalancedTreeHelper(TreeNode root) {
        // An empty tree is balanced and has height = -1
        if (root == null)
            return new TreeInfo(-1, true);

        TreeInfo left = isBalancedTreeHelper(root.left);
        if (!left.balanced) {
            return new TreeInfo(-1, false);
        }
        TreeInfo right = isBalancedTreeHelper(root.right);
        if (!right.balanced) {
            return new TreeInfo(-1, false);
        }

        if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new TreeInfo(-1, false);
    }

    public boolean isBalanced(TreeNode root) {
        return isBalancedTreeHelper(root).balanced;
    }
}