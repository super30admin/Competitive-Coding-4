 // Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
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
       
      return helper(root)!= -1;
       
   }
   
   private int helper(TreeNode root){
       if(root == null) return 0;
       int l = helper(root.left);
       int r = helper(root.right);
       if(l==-1|| r==-1){
           return -1;
       }
       if(Math.abs(l-r) >1) return -1;
       return 1+ Math.max(l,r);
   }
} {
    
}
