public class BalancedBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        int diff = 0;
        int lHeight = height(root.left);
        if (lHeight == -1)
            return -1;

        int rHeight = height(root.right);
        if (rHeight == -1)
            return -1;

        diff = Math.abs(lHeight - rHeight);
        if (diff > 1)
            return -1;

        return Math.max(lHeight, rHeight) + 1;

    }

}

//TC: O(n)
//SC: O(n) - recursive stack space if it is a skewed tree or O(H) or O(log n) for balanced tree