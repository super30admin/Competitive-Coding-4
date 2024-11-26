// Time Complexity : O(n) ; n is nodes in binary tree
// Space Complexity : O(n) ; space for recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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
class Solution {
    private Boolean isBal; // creating a global variable

    public boolean isBalanced(TreeNode root) {
        isBal = true;
        helper(root);
        return isBal;

    }

    private int helper(TreeNode root) {
        // base
        if (root == null) { // if root is null , then height =0
            return 0;
        }

        // logic
        int left = helper(root.left); // calling nodes on left side of root
        int right = helper(root.right);

        if (Math.abs(left - right) > 1) { // if differnece between height of right and left subtree is greater than 1
                                          // then it is not balanced
            isBal = false;
        }

        return 1 + Math.max(left, right); // returning height or tree

    }
}