/**
Time complexity: O(N)
Space complexity: O(H)
Algorithm:
=========
1. Calculate heights of left and right subtrees and check difference of heights of both at every step
2. If at any point of time, if difference of heights is greater than 1, return false
3. Else, tree is height-balanced
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
       if(root == null)
           return true;
        return height(root)!= -1 ;			
    }
    
    private int height(TreeNode root) {
        if(root == null)
            return 0;						// edge case
        
        int left = height(root.left);		// check if left subtree is height-balanced recursively
        if(left == -1)
            return -1;
        int right = height(root.right);		// check if right subtree is height-balanced recursively
        if(right == -1)
            return -1;
        if(Math.abs(left-right) > 1)		// if difference of heights of both subtrees greater than 1, not height balanced
            return -1;
        return Math.max(left,right)+1;		// Return max height of binary tree if height balanced
    }
}