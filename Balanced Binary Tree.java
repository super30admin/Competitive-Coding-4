// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
        
        if(helper(root)==-1)
        return false;

        else 
        return true;

    }

    public int helper(TreeNode root)
    {
        if(root == null)
        return 0;

         
         int left= helper(root.left);
         
        if(left==-1)
        return -1;

         int right = helper(root.right);

         if(right==-1)
        return -1;

         if(Math.abs(left-right)>1)
         return -1;

         else
         return Math.max(left,right)+1;

        

    }
}