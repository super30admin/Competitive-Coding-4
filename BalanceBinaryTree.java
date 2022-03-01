// TC: O(n)
// SC: O(1)
// Bottom Up

// Approach: start from the bottom nodes and check the height difference 
// between left and right subtrees.

// LC- 110. Balanced Binary Tree

public class BalanceBinaryTree {
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

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    if (Math.abs(height(root.left) - height(root.right)) > 1) {
      return false;
    }

    return isBalanced(root.left) && isBalanced(root.right);
  }

  public int height(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int left = height(node.left);
    int right = height(node.right);

    int balanceFactor = Math.abs(left - right);

    if (balanceFactor > 1 || left == -1 || right == -1) {
      return -1;
    }

    return 1 + Math.max(left, right);
  }
}
