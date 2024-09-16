// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean isBalanced(TreeNode root) {
        //base case when the root is null
        if(root == null) 
            return true;
        
        //returns true when both subtrees are balanced and difference of height between two children is less than or equal to 1
        return isBalanced(root.left) && isBalanced(root.right) && 
            Math.abs(height(root.left) - height(root.right)) <= 1;
    }
    
    private int height(TreeNode root){
        
        //the null nodes are 0 and as we move up we add 1 to each height based on max child height
        if(root == null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
    }
}