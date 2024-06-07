// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
 * Approach:
 * To check whether the tree is balanced, we recursively check whether the
 * subtrees are balanced or not all the while keeping track of the heights
 * of each subtree.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        if(Math.abs(leftH-rightH) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if(root == null) {
            return -1;
        }

        // leaf
        if(root.left == null && root.right == null) {
            return 0;
        }

        return 1+Math.max(
            getHeight(root.left),
            getHeight(root.right)
        );
    }
}