// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
/*
 * we calculate the height of left and right subtree. if the height difference is gretaer than 1 we return -1.
 * if either of the subtree return -1, that means it is not balanced so retrun -1.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return height(root) != -1;
    }

    private int height(TreeNode root) {
        // base
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        if (left == -1 || right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }
}