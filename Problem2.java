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
//Problem - Balanced Binary Tree
//Time complexity - O(n) where n is number of nodes in binary tree
//Space complexity - O(n) when case od unbalanced tree height of the tee is n
//Code run successfully on Leetcode - Yes
class Solution {
    public boolean isBalanced(TreeNode root) {

        //condition for root is null
        if(root == null)
        return true;
        return height(root) != -1;
        
    }

    private int height(TreeNode root){
        if(root == null)
        return 0;

        //calculating the heights of left and right subtrees
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1)
        return -1;

        //check if either the left or right subtree is unbalanced
        if(left == -1 || right == -1)
        return -1;
        return Math.max(left, right) +  1;
    }
}