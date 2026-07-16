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
        this.flag=true;
        helper(root);
        return flag;
    }
    private int helper(TreeNode root){
        if(root==null) return 0;
        int left=0;
        int right=0;
        if(flag){
        left=helper(root.left)+1;
        }
        if(flag){
            right=helper(root.right)+1;
        }
        if(Math.abs(right-left)>1){
            flag=false;
        }
        return Math.max(right,left);
    }
}
