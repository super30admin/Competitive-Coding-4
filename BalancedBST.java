// Time Complexity : O(n^2)),
// Space Complexity : O(1),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package competitiveCoding4;

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

public class BalancedBST {

    public boolean isBalanced(TreeNode root) {
        int lh;

        int rh;

        if (root == null) {
            return true;
        }

        lh = height(root.left);
        rh = height(root.right);

        if (Math.abs(lh - rh) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right)) {
            return true;
        }

        return false;
    }

    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
