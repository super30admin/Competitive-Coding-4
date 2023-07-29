// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: We will calculate the height of each node and check if the difference between it and the next node is less than equal to 1. To calculate the height, we will go at the leaf node and keep adding it until we reach the root.
class Solution {
    public boolean isBalanced(TreeNode root) {
    if(root==null) return true;
        int l=height(root.left);
        int r=height(root.right);

      if (Math.abs(l - r) <= 1 && isBalanced(root.left) && isBalanced(root.right))  
            return true;              
    return false;

    }

    private static int height(TreeNode root)
    {    
        //base
        if(root==null) return 0;
        
        //logic
        return 1 + Math.max(height(root.left),height(root.right));   

    }
}