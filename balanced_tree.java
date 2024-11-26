// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {

  public boolean isBalanced(TreeNode root) {
    return helper(root, 0) >= 0;
  }

  public int helper(TreeNode root, int height) {
    if (root == null) return height;
    //we calculate the height of the left and the right subtree
    int left = helper(root.left, height + 1);
    int right = helper(root.right, height + 1);

    //If the height is less than 0 or the absolute difference between the two height is greater than 1
    //then the tree is not balanced
    if (left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;
    return Math.max(left, right);
  }
}
