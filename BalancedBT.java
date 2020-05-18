// Time Complexity : O(n)-> where n is number of nodes in Binary tree
// Space Complexity : O(h)-> height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  I was focussing mainly on returning the valid condition and caused a silly error. I should focus on returning false condition.
/* Your code here along with comments explaining your approach: Calculate the height of each and every node to check if the tree is balanced.
The balance condition is that the height of the left subtree of a node and right subtree of a node should be <= 1. If there is violation, return -1,
elsewise return true. We need to call the height function for each and every node to check the validity of a balanced Binary tree.
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
      if(root == null){ return true;}
     return height(root) == -1? false : true;                   // If the -1 is returned => false
    }
    private int height(TreeNode root){
        if(root == null){return 0;}
        int left = height(root.left);                           // Check height of left subtree
        int right = height(root.right);                         // Check height of right subtree
        if(Math.abs(left - right) > 1 || left == -1 || right == -1){                // Check if the balanced condition is correct
            return -1;
        }
        return 1 + Math.max(left, right);                       // return the height of the particular node from bottom to top
    }
}