// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    private boolean flag;

    public boolean isBalanced(TreeNode root) {
        flag = true;
        helper(root);
        return flag;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        if (Math.abs(left - right) > 1)
            flag = false;
        return Math.max(left, right) + 1;
    }
}