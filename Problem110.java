// Time Complexity : O(n logn)  -->depth caluculation is logn and it is caluculated at every node
// Space Complexity :  O(n) -->recurssion stack and worst case is n 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
        if(root ==null) return true;
     int  left =  helper(root.left);
     int right = helper(root.right);

     if(Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right))
     {
         return true;
     }
      return false;  
    }

    public int helper(TreeNode root)
    {
        if(root ==null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        return  1+ Math.max(left,right);
    }
}