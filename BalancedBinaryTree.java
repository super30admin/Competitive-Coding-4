// TC: O(n)
// SC: O(h)
// Approach: Check for height at every node by making recursive calls 
// Check if height difference if less than 1 , if not return false
// if yes return max of left or right 

public class BalancedBinaryTree {

  public class TreeNode {
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

  private boolean result = true;

  public boolean isBalanced(TreeNode root) {
    maxDepth(root);
    return result;
  }

  private int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = maxDepth(root.left);
    int right = maxDepth(root.right);

    if (Math.abs(left - right) > 1) {
      result = false;
    }
    return Math.max(left, right) + 1;
  }

}
