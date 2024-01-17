// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
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
        if(root == null) return true;
       
    
        if(height(root) == -1) return false;
        else return true;
    }

    private int height(TreeNode root){
        if(root == null) return 0;
        int lh = height(root.left); //height of left subtree
        int rh = height(root.right); //height of right subtree
       
        if(lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) return -1;  //if tree is unbalanced
        return Math.max(lh,rh) + 1;
         

    }
}