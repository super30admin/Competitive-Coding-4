// Time Complexity : O(n log n)
// Space Complexity : O(n)
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
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        // find the left sub tree height
        int leftHeight = height(root.left);
        // find the right sub tree height
        int rightHeight = height(root.right);

        int heightDiff = Math.abs(leftHeight - rightHeight);
        // recursively chek left and right sub tree is balanced and height diff is less than 2
        return heightDiff < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if(root == null) {
            return -1;
        }

        return 1+ Math.max(height(root.left), height(root.right));
    }
}