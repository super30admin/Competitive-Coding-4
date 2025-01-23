/**
 * Time complexity: O(n)
 * Space complexity: O(h)
 * Ran on leetcode? Yes
 * Issues faced? None
 *
 * Approach:
 * Since for a balanced BT, each subtree should also be balanced, so recursively look for
 * all subtree and child nodes to determine their depth from
 * its parent node and then pass that depth on to the parent.
 */
public class BalancedBinaryTree {

     // Definition for a binary tree node.
     public class TreeNode {
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

    // Stores the result of isBalanced method
    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        check(root);
        return result;
    }

    /**
     * Helper method to recursively check each node starting from root node for whether it is balanced or not
     */
    private int check(TreeNode root) {
        if(root == null)
            return 0;
        int lh = check(root.left);
        int rh = check(root.right);

        if (Math.abs(lh - rh) > 1) {
            result = false;
        }
        return Math.max(lh, rh) + 1;
    }
}
