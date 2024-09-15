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
// TC : O(NlogN)
// SC : O(N)
// Did it run successfully on Leetcode? : Yes
class Solution {
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if ( root == null)
            return true;
       return (Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right));
        
    }
    private int height(TreeNode root)
    {
        //base
        if ( root == null)
            return 0;
        
        //logic
        return 1+Math.max(height(root.left), height(root.right));
    }
}
