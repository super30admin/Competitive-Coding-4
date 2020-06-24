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

/**
 * Time: O(n) n-nodes of the tree
 * Space: O(1)
 */
class Solution {
    int flag = 0;
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        int left = helper(root.left,0);
        int right = helper(root.right,0);

        if(Math.abs(right-left) > 1 || flag == 1)return false;
        return true;
    }
    public int helper(TreeNode node,int level){
        if(node == null)return level;

        int left = helper(node.left,level)+1;
        int right = helper(node.right,level)+1;
        if(Math.abs(right-left) > 1) flag = 1;
        return Math.max(left,right);
    }
}