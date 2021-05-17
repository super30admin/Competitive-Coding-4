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
    //Time O(N)
    //Space O(N)
    //Bottom up approach
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        return helper(root) != -1;
    }
    public int helper(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int case1 = helper(root.left);
        int case2 = helper(root.right);
        if(case1 == -1 || case2 == -1 || Math.abs(case1-case2) > 1)
        {
            return -1;
        }
        return Math.max(case1 , case2)+1;
    }
}