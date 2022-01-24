public class Balanced {
    // TC O(N)
    // SC O(h) - h is height of tree
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

    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        helper(root);
        return balanced;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + helper(root.left);
        int right = 1 + helper(root.right);
        if (Math.abs(right - left) > 1) {
            balanced = false;
            return Math.max(left, right);
        }
        return Math.max(left, right);
    }
}
