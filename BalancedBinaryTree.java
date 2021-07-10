// Time Complexity : O(n)
// Space Complexity : O(h)

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
        if(diff(height(root.left, 1),height(root.right, 1)) > 1)
           return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int diff(int a, int b){
        if(a > b)
            return a - b;
        else
            return b - a;
    }
    
    private int height(TreeNode root, int level){
        if(root == null)
            return 0;
        
        return Math.max(height(root.left, level),height(root.right, level)) + 1;
    }
}