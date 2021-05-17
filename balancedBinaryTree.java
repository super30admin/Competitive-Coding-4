// Time complexity - O(n)
// Space complexity - O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
   // boolean globalVariable = true;
    public boolean isBalanced(TreeNode root) {
        
      int result =   helper(root);
      if(result == -1){
          
          return false;
      }
       
        return true;
        
    }
    
    private int helper(TreeNode root){
        
        if(root == null){
            
            return 0;
        }
    //    System.out.println("height is" + height);
        int left = helper(root.left);
        if(left == -1){
            
            return -1;
        }
        int right = helper(root.right);
         if(right == -1){
            
            return -1;
        }
        if(Math.abs(left - right) != 0 && Math.abs(left - right) != 1) {
            
            return -1;
        }
        
        return Math.max(left,right) + 1;
    }
}