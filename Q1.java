// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


class Solution {
  
    private int helper(TreeNode root){
        //base
        if(root==null)return 0;
        int left=helper( root.left); //2
        if(left==-1)return -1;
        int right=helper( root.right);//0
        if(right==-1)return -1;
        if(Math.abs(left-right)>1)return -1;
        return 1 + Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root)!=-1;
    }
    
}
