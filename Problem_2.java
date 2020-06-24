// Time complexity - O(n)
// Space complexity - O(1)

// Recursive solution

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
        if(root == null){
            return true;
        }
        
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left)-height(root.right)) <= 1;
    }
    
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        else{
            return Math.max(height(root.left),height(root.right)) + 1;
        }
        
    }
}
