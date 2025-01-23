// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class BalancedBinaryTree {

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (helper(root) == -1) {
      return false;
    }
    return true;
  }

  private int helper(TreeNode root) {
    // base case
    if (root == null) {
      return 0;
    }
    int leftHeight = helper(root.left);
    if (leftHeight == -1) {
      return -1;
    }
    int rightHeight = helper(root.right);
    if (rightHeight == -1) {
      return -1;
    }
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }
    return 1 + Math.max(leftHeight, rightHeight);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
