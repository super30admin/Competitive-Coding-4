
//Time Complexity functions: O(n)
//Space Complexity : O(n)
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
/*
We start from the root node. Do inorder traversal. Check the left height and right height at each node. If height difference is
> 1 then set flag as false. Return false at the end.
*/
class BalancedBinaryTree {

   boolean flag=true;
   public boolean isBalanced(TreeNode root) {
       helper(root);
       return flag;
   }

   private int helper(TreeNode root){
       if(root==null || !flag){
           return 0;
       }
       
       int leftht=1+helper(root.left);
       int rightht=1+helper(root.right);
       if(Math.abs(leftht-rightht)>1){
           flag=false;
       }
       return Math.max(leftht,rightht);
   }
}