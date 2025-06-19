// Time Complexity: O(n) where n is the number of elements in the tree
// Space Complexity: O(1) other than the recursive stack which can get to O(n) for a skewed tree
// Did this code successfully run on Leetcode: Yes

public class BalancedBinaryTree {
    boolean result = true;

    public boolean isBalanced(TreeNode root) {

        helper(root);

        return result;
    }

    public int helper(TreeNode root) {
        //base
        if (root == null || !result) return -1;
        //logic
        int left = helper(root.left);
        int right = helper(root.right);

        if(Math.abs(right - left) > 1) {
            result = false;
        }

        return Math.max(left, right) + 1;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
