// Time Complexity : O(n)
// Space Complexity : O(1) (recursive stack - O(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    private boolean bal=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        height(root);
        return bal;
    }
    
    private int height(TreeNode root){
        if(root==null) return 0;
        
        int left=height(root.left);
      
        int right=height(root.right);
             
        if((Math.abs(left-right))>1){
            bal= false;
        }
        return 1+Math.max(left,right);
    }
}