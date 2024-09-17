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
//Time Complexity: O(n); Since we are trversing through every node in the tree
// Space Complexity: O(n) Stack space. Because our recursion is done on each node to find its height.
// Leetcode: 110. Balanced Binary Tree - Easy

class Solution {
    boolean res=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
       if( Math.abs( findheight(root.left) - findheight(root.right)) > 1)
           res=false;
        return res;
    }
    
    public int findheight(TreeNode node)
    {
        if(node==null)
            return 0;
        
        int lheight=findheight(node.left);
        int rheight=findheight(node.right);
        if( Math.abs(lheight-rheight)>1)
        {
            res=false;
            
        }
        return Math.max(lheight,rheight)+1;
        
        
    }
}