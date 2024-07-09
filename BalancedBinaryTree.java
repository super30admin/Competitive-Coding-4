// Time Complexity : O(n)
// Space Complexity : O(h), best case - O(log n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
    return height(root) != -1;
  }

  int height(TreeNode root) {
    // Base
    if(root == null) {
      return 0;
    }

    // Logic
    int leftHeight = height(root.left);
    if(leftHeight == -1) return -1; // Returns -1 if the left subtree is unbalanced
    int rightHeight = height(root.right);
    if(rightHeight == -1) return -1; // Returns -1 if the right subtree is unbalanced

    if(Math.abs(leftHeight - rightHeight) > 1) return -1; // Returns -1 if the difference between the left and right subtrees is more than 1.

    return Math.max(leftHeight, rightHeight) + 1;
  }
}