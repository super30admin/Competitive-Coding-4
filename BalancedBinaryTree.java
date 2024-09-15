// Time Complexity : O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
Top Down Recursion

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
        if(root == null) {
         return true;
        }
        return Math.abs(height(root.left) - height(root.right)) < 2
            && isBalanced(root.left) && isBalanced(root.right);
    }
    private int height(TreeNode root)
    {
        if(root == null)
        {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
Botton up recursion


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
        if(root == null)
            return true;
        return height(root)!=-1;
    }
    private int height(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
      
        int lh = height(root.left);
        int rh = height(root.right);
        if(lh == -1 || rh == -1 || (Math.abs(lh-rh)) > 1)
            return -1;
        return 1 + Math.max(lh,rh);    
    }
}