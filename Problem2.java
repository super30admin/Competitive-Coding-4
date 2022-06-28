// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//
//110. Balanced Binary Tree
//https://leetcode.com/problems/balanced-binary-tree/

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
class Problem2 {

    boolean flag = true;

    public boolean isBalanced(TreeNode root) {

        helper(root);

        return flag;
    }

    private void helper(TreeNode root) {
        // base
        if (root == null) {
            return;
        }

        // logic
        helper(root.left);
        int hLeft;
        if (root.left == null)
            hLeft = 0;
        else
            hLeft = height(root.left);// 0 //1

        helper(root.right);
        int hRight;
        if (root.right == null)
            hRight = 0;
        else
            hRight = height(root.right);// 0

        if (hLeft > 1 + hRight || hRight > 1 + hLeft) {
            flag = false;
        }

    }

    private int height(TreeNode root) {
        // base
        if (root == null)
            return 0;

        // logic
        int hL = height(root.left);

        int hR = height(root.right);

        int height = 1 + Math.max(hL, hR);
        return height;
    }

}