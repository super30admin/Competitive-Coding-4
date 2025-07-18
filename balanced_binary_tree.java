// In this solution, we  program to check if given tree is Balanced Binary Tree by using DFS
// TC: O(n) - where n is the total number of nodes
// SC: O(h) - height of the tree

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
        if(root == null){
            return true;
        }
        int result = dfs(root);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public int dfs(TreeNode node){
        if (node == null){
            return 0;
        }
        // Traverse Left Node
        int left = dfs(node.left);
        // Traverse Right Node
        int right = dfs(node.right);
        // If either side is -1 it indicates that the side is un-balanced. 
        // If Abs value of height difference is > 1 it indicates un-balance
        // In both scenarios we return -1
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        // Else return abs value of height
        return 1 + Math.max(left,right);
    }
}
