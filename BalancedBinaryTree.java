// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// The basic idea is to calculate the height of the left and right sub trees for each node and check if their height differs by more than 1 
class Solution {
    private boolean result;
    public boolean isBalanced(TreeNode root) {

        result = true;
        height(root);
        
        return result;
    }
    
    private int height(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        
        if(Math.abs(left - right) > 1)  {
            result = false;
        }
        
        return 1 + Math.max(left, right);            
    }
    
}
