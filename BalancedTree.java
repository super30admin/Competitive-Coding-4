// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are iterating through all the nodes
//Space Complexity: O(1) since we are not taking any extra space except result array
class Solution {
        
    public boolean isBalanced(TreeNode root) 
    {
        if(root == null) return true;
        
        int leftCount = helper(root.left, 0);
        int rightCount = helper(root.right, 0);
        if(Math.abs(leftCount - rightCount) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int helper(TreeNode root, int count)
    { 
        //Base condition
        if(root == null) return count;        
        count++;        
       
        return Math.max(helper(root.left, count), helper(root.right, count));
    }
}