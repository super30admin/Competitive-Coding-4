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
    boolean f_h = true;
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)
            return true;
        recurr(root);
        return f_h;
        
    }
    private int recurr(TreeNode root){
        if(f_h == false)
            return -1;
        if(root == null){
            return 0;
        }
        int left_h = recurr(root.left);
        int right_h = recurr(root.right);
        
        if(Math.abs(right_h - left_h)> 1){
            f_h = false;
        } 
        return Math.max(left_h, right_h)+1;
    }
}
