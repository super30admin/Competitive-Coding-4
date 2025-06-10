//height difference between the left and right subtrees of every node is at most 1. It uses a bottom-up recursive height function that returns -1 immediately if any subtree is unbalanced. The isBalanced function returns true only if the final height is not -1.
//Time complexity: O(n)
//Space complexity: O(h)
class Solution {

   public boolean isBalanced(TreeNode root) {

       return height(root) != -1;

   }

   private int height(TreeNode root){

       if(root == null) return 0;

       int left = height(root.left);

       int right = height(root.right);

       if(Math.abs(left - right) > 1 || 

          left == -1 || right == -1) return -1;

       return Math.max(left, right) + 1;

   }

}