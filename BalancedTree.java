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
//Time Complexity: O(n2)
//Space Complexity: O(n2)
class Solution {
    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;

        int leftDepth = depth(root.left, 0);
        int rightDepth = depth(root.right, 0);

        if(Math.abs(leftDepth - rightDepth) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root, int height)
    {
        //Base case
        if(root == null) return height;
        height++;

        return Math.max(depth(root.left, height), depth(root.right, height));
    }
}