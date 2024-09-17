https://leetcode.com/problems/balanced-binary-tree/description/

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No



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
        //Passing root node in recursive function
        int res = ht(root);
        return res != -1;
    }
//Recursive function which checks if the tree is balanced
// If tree is balanced, return height if not return -1
    public int ht(TreeNode root){
        if(root == null) return 0;

        int a = ht(root.left);
        int b = ht(root.right);

        if(a==-1 || b==-1) return -1;
        if(Math.abs(a-b)>1) return -1;

        return Math.max(a,b) +1;
    }
}