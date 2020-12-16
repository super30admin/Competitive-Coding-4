// Time Complexity :O(N)
// Space Complexity :O(H) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        helper(root);
        return flag;
    }
    public int helper(TreeNode root){
        
        if(flag == false)
            return 0;
        if(root==null)
            return 0;
        int ld = 0;
        int rd = 0;
        
        if(root.left==null && root.right ==null)
            return 1;
        ld = helper(root.left);
        
        rd = helper(root.right);
        
        if(Math.abs(ld-rd)>1)
            flag=false;
        
        int depth = Math.max(ld,rd)+1;
        
        return depth;
    }
}