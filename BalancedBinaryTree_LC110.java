//Time Complexity: O(N) – Visits each node once
//Space Complexity: O(H) – Stack space for recursion
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes with count logic

//Using bottom-up DFS approach to:
//1. Compute the height of each subtree.
//2. Use -1 as a signal to short-circuit if the tree is already unbalanced.
//    If any subtree is unbalanced → propagate -1 upward.
//    If current node is unbalanced → return -1.
//

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
class BalancedBinaryTree_LC110 {
    
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root){
        if (root == null) return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

}