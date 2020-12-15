// Time Complexity : O(N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public boolean isBalanced(TreeNode root) {
                  
        
        return helper(root).isBal;
        
    }
    
    private Result helper(TreeNode root) {
        
        Result res = new Result(0, true);
        
        if(root == null) return res;
        
        Result left = helper(root.left);
        Result right = helper(root.right);
        
        if(!left.isBal || !right.isBal) {
            
            res.isBal = false;
            return res;
        }
        
        
        if(Math.abs(left.h - right.h) < 2) {
            
            res.h = Math.max(left.h, right.h) + 1;
            res.isBal = true;
            return res;
        }
        
        res.isBal = false;
        
        
        return res;
    }
}
    


class Result {
    int h;
    boolean isBal;
    
    public Result(int h, boolean isBal) {
        
        this.h = h;
        this.isBal = isBal;
    }
}