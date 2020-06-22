// Time Complexity : O(n). n is the number of nodes in a Linked list
// Space Complexity : O(n)
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
        if(root==null) return true;
        
        if(isBal(root)<0) return false;
        return true;
    }
    
    private int isBal(TreeNode node){
        if(node==null) return 0;
        
        int left = isBal(node.left);
        
        if(left==-1) return -1;
        int right = isBal(node.right);
        if(right==-1) return -1;
        if(Math.abs(left-right)>1) return -1;
        
        return 1+Math.max(left,right);
    }
}
