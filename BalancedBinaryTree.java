// Time Complexity : O(n) where n is the number of nodes
// Space Complexity : O(h) where h i sthe height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
 class BalancedBinaryTree {
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
  public boolean isBalanced(TreeNode root) {
   if(helper(root) == -1){
    return false;
   }
   return true;
  }
  private int helper(TreeNode root){

   //base case
   if(root == null)
    return 0;

   int lh = helper(root.left);
   int rh = helper(root.right);

   if(Math.abs(lh-rh) > 1 || lh == -1 || rh == -1)
    return -1;

   return Math.max(rh,lh)+1;
  }
}
