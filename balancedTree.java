
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
/*
 Tc --> O(n)
 Sc --> O(1)
 */
class Solution {

    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Helper(root);
        return flag;

    }

    public int Helper(TreeNode root) {

        if (root != null) {
            if (flag == false) {
                return 0;
            }
            int left = Helper(root.left);
            int right = Helper(root.right);
            if (Math.abs(left - right) > 1) {
                flag = false;
            }
            return Math.max(left, right) + 1;

        }//if
        return 0;

    }//method
}
