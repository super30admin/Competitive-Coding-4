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
        return heightHelper(root) >= 0;
    }

    public int heightHelper(TreeNode tree){
        if(tree == null) return 0;

        int left = heightHelper(tree.left);
        if (left == -1) return -1;

        int right = heightHelper(tree.right);
        if (right == -1) return -1;

        //System.out.println("Sysout"+left+","+right);
        if(Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
}