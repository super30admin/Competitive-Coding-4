// Time Complexity : O(n)
// Space Complexity : O(log n) worst case: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
    boolean bal  = true;
    public boolean isBalanced(TreeNode root) {
        int h = helper(root);
        return bal;
    }

    public int helper(TreeNode node) {
        if (node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        if (Math.abs(left - right) > 1) {
            bal =  false;
        }
        return 1 + Math.max(left,right);
    }
}