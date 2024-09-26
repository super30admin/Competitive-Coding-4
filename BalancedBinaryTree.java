//https://leetcode.com/problems/balanced-binary-tree/
/*
Time: O(n) where n is the number of nodes in the given tree
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return maxDepth(root) != -1;

    }

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        int bf = Math.abs(lDepth - rDepth);

        if (bf > 1 || lDepth == -1 || rDepth == -1)
            return -1;

        return Math.max(lDepth, rDepth) + 1;

    }
}
