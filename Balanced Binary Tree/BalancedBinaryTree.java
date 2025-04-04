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
 
 //TC: O(nlogn)
 //SC: O(n)
class Solution {
    public boolean isBalanced(TreeNode root) {
        return help(root);
    }

    public boolean help(TreeNode root){
        //base case
        if(root == null)return true;

        //logic
        int left_height = calculate_height(root.left, 0);
        int right_height = calculate_height(root.right, 0);

        if(Math.abs(left_height - right_height) > 1)return false;
        return help(root.left) && help(root.right);
    }

    public int calculate_height(TreeNode node, int level){
        //base case
        if(node == null)return level;

        //logic
        int curr_height = level + 1;
        int left = calculate_height(node.left, curr_height);
        int right = calculate_height(node.right, curr_height);

        return Math.max(left, right);
    }
}