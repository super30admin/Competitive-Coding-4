// Time Complexity : O(n)
// Space Complexity : O(log(n)) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    
    boolean d;
    public boolean isBalanced(TreeNode root) {
        
        d=true;
        helper(root);
        return d;
        
    }
    
    public int helper(TreeNode root) {
        
        if(root==null) return 0;
        
        // find left and right height
        int lh = helper(root.left);
        int rh = helper(root.right) ;
        
        // if left and right height differ by mopre than 1 our tree are not balanced
        if(Math.abs(lh-rh)>1) d = false;
        
        return Math.max(lh, rh) + 1;       
        
    }
}
