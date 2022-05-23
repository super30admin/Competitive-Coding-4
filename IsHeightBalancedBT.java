/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class IsHeightBalancedBT {
  // Time Complexity : O(n)
  // Space Complexity : O(n)
  // Did this code successfully run on Leetcode : Yes

  private static int helperMethod(TreeNode root) {
    // Base case.
    if (root == null) {
      return 0;
    }

    int leftValue = helperMethod(root.left);
    int rightValue = helperMethod(root.right);

    // If one of them is '-1' then child subtree are not balanced.
    if (leftValue == -1 || rightValue == -1) {
      return -1;
    }

    // Allow only '0, -1, 1' height differencein 'left' child subtree height and
    // 'right' subtree height.
    if (Math.abs(leftValue - rightValue) <= 1) {
      return Math.max(leftValue, rightValue) + 1;
    }

    // If left and right child subtree height more than '2'.
    return -1;

  }

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (helperMethod(root) != -1) {
      return true;
    } else {
      return false;
    }
  }
}