// Time Complexity : O(n)
// Space Complexity : O(h) -- bestcase, O(n) -- worstcase
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Check the left and right heights of the binary tree recursively 
 * If the difference of heights is more than 1 or leftHeight ==-1 or rightHeight==-1 then it is not balanced
 * Else it is a balanced binary tree
 */
  
 
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int height = height(root);
        if(height==-1)
            return false;
        return true;
        
    }
    private int height(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1 || leftHeight ==-1 || rightHeight==-1 )
            return -1;
        return Math.max(leftHeight, rightHeight)+1;
    }
}