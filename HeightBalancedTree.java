// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


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
class HeightBalancedTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        //base
        if(root == null) return 0;
        //logic
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1) return -1;
        if(left == -1 || right == -1) return -1;
        return Math.max(left, right) + 1;

    }
}