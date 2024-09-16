/* Time Complexity :  O(n)
   Space Complexity : O(h)  
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
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
    boolean res=true;
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int sum =helper(root);
        return res;
    }
    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = 1+helper(root.left);
        int right = 1+helper(root.right);
        if(Math.abs(left-right) > 1)
        {
            res=false;
            return 0;
        }
        return Math.max(left,right);
    }
}