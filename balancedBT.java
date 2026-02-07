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
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;

        dfs(root);
        return result;
    }

    private int dfs(TreeNode root){
        if(root == null || !result)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(Math.abs(left-right) > 1) result = false;

        return Math.max(left,right)+1;
    }
}