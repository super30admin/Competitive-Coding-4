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
        int result = helper(root);
        if(result!=-1) return true;
        return false;
    }
    private int helper(TreeNode root){
        if(root==null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if(l==-1 || r==-1 || Math.abs(l-r)>1) return -1;
        return Math.max(l,r)+1;
    }
}