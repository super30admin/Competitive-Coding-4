package Competitive-Coding-4;
//Q 110:- Leetcode
public class problem1 {
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
    boolean ans=true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return ans;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        
       int left =  helper(root.left);
       int right = helper(root.right);
        
        if(Math.abs(left - right) <= 1){
             ans = ans&&true;
        }else{  
        ans=ans&&false;
        }
         return Math.max(left,right) + 1;
    }
}
