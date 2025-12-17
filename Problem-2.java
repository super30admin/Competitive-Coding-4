// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// We use post-order traversal to compute the height of left and right subtrees.
// At each node, we check if the height difference is greater than 1 to detect imbalance.
// If any subtree is unbalanced, we return -1 and propagate it upward; otherwise return height.

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
        return helper(root) != -1;
    }
    private int helper(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = helper(root.left);
        if (left == -1){
            return -1;
        }

        int right = helper(root.right);
        if (right == -1){
            return -1;
        }

        if (Math.abs(left-right)>1){
            return -1;
        }

        return Math.max(left,right)+1;
    }
}