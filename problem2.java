// Problem - https://leetcode.com/problems/balanced-binary-tree/submissions/

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class problem2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return height(root) != -1;
    }

    public int height(TreeNode node) {

        if (node == null)
            return 0;

        int left = height(node.left);
        int right = height(node.right);
        int value = Math.abs(left - right);

        if (value > 1 || left == -1 || right == -1)
            return -1;
        return 1 + Math.max(left, right);
    };
}
