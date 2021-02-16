// Time Complexity :O(n)
// Space Complexity :O(max depth)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
     boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null || root.left==null && root.right==null)
            return true;
        
       
         DFS(root);
        return flag;
        
    }
    private int DFS(TreeNode root)
    {       
        
        if(root==null)
            return 0;
        
        int left=DFS(root.left);
        int right=DFS(root.right);
        if(Math.abs(left-right)>1)
            flag=false;
        return Math.max(left,right)+1;
    }
}