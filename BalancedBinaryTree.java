// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Have a helper function which will recursively calculate the heights of both left and right subtrees. If,
their difference becomes greater than 1, we set the boolean flag as false which acts as our final answer.
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
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        this.flag = true;
        isBalancedTreeHelper(root);
        return flag;
    }

    private int isBalancedTreeHelper(TreeNode root) {
        if(root == null)
            return 0;
        int left = 0;
        int right = 0;
        if(flag)
            left = isBalancedTreeHelper(root.left) + 1;
        if(flag)
            right = isBalancedTreeHelper(root.right) + 1;
        if(Math.abs(left - right) > 1)
            flag = false;
        return Math.max(left, right);
    }
}