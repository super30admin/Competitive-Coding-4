// Time Complexity : O(n log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Forgot about reverse

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

        if(root==null)
            return true;

        return
                isBalanced(root.left)&&
                        isBalanced(root.right)&&
                        Math.abs(height(root.left)-height(root.right)) < 2;
    }
    public int height(TreeNode root)
    {
        if(root==null)
            return 0;

        return Math.max(height(root.left),height(root.right))+1;
    }

}