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
    int height;
    boolean result;

    public boolean isBalanced(TreeNode root) {
        result = true;
        if (root == null) {
            return true;
        }
        height = post(root, 0);
        if (height == -2)
            result = false;
        return result;
    }

    private int post(TreeNode root, int height) {
        if (root == null) {
            return -1;
        }

        int left = post(root.left, height);
        if (left == -2)
            return left;
        int right = post(root.right, height);
        if (right == -2)
            return right;
        if (Math.abs(left - right) <= 1) {
            height = Math.max(left, right) + 1;
            System.out.println(root.val + " " + height);
        } else {
            height = -2;
        }
        return height;
    }
}