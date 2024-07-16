// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    boolean flag;

    public boolean isBalanced(TreeNode root) {
        this.flag = true;
        helper(root);
        return flag;
    }

    private int helper(TreeNode root) {
        // base
        if (root == null)
            return 0;
        // logic

        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            flag = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }
}