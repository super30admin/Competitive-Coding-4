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
        
        if (root == null){
            return true;
        }
        int l = helper(root.left);
        int r = helper(root.right);
        
        if (Math.abs(r-l) > 1){
            return false;
        }
        else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        
    }  
    public int helper(TreeNode root){
        if (root == null)
            return 0;
        if (root.left == null && root.right == null){
            return 1;
        } 
        return 1 + Math.max(helper(root.left),helper(root.right));    
        
    }
}