// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// As you are calculating height, also check if diff of heights is
// less than 2.

class TreeNode {
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

class BalancedBinaryTree {
    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        int h = helper(root);
        return isBalanced;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = helper(node.left);

        if (!isBalanced) {
            return 0;
        }

        int right = helper(node.right);

        if (Math.abs(left - right) > 1) {
            isBalanced = false;
            return 0;
        }

        return 1 + Math.max(left, right);
    }
}