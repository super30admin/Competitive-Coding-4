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
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// get the hight of leaf node and then take the abs different and check if it is > 1, if yes then return false; return the max hight + 1 to the parrent when return
// Your code here along with comments explaining your approach
class Solution {
    boolean result;
    public boolean isBalanced(TreeNode root) {
        result = true;
        if( root == null ) return result;
        helper(root);
        return result;
    }
    private int helper(TreeNode root){
        //base
        if( root == null ) return 0;
        //logic
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left-right)>1){
            result = false;
        }
        return Math.max(left, right) + 1;
    }
}