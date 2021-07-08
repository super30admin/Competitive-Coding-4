class BalancedBinaryTree {

    //Time Complexity: O(n)
    //Space Complexity: O(nlogn)

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(helper(root.left) - helper(root.right)) <= 1;

    }

    private int helper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return Math.max(helper(root.left), helper(root.right)) + 1;

    }
}