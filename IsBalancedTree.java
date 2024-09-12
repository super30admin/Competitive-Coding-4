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
 
 
 TC - O(N)
 SC - O(N)
 
 
 */
class Solution {
    
    private boolean isBalanced;
    
    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        isBalancedHelper(root);
        
        return isBalanced;
    }
    
    private int isBalancedHelper(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        
        // recur on left tree
        int leftH = isBalancedHelper(root.left);
        
        // recur on right tree
        int rightH = isBalancedHelper(root.right);
        
        if (Math.abs(leftH - rightH) > 1)
        {
            isBalanced = false;
        }
        
        return 1 + Math.max(leftH, rightH);
    }
}
