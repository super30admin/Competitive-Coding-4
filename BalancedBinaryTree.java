// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        int result = height(root);
        if(result == -1)
            return false;
        else
            return true;

    }

    private int height(TreeNode root){
        //base
        if(root == null)
            return 0;

        //logic
        int left = height(root.left);
        if(left == -1)
            return -1;
        int right = height(root.right);
        if(right == -1)
            return -1;
        if(Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right)+ 1;
    }
}