/**
Time complexity: O(N)
Space complexity: O(H)
Algorithm:
=========
1. 
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int height = Math.abs(height(root.left) - height(root.right));
        return height <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root) {
        if(root == null) return -1;
        
        return Math.max(height(root.left), height(root.right))+1;
    }
}