// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class BalancedTreeOptimized {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) > 1) return -1;
        if (left == -1 || right == -1) return -1; // stop the recursion when an imbalance is found
        return Math.max(left, right) + 1;
    }
}
