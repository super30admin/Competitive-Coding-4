// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


/** https://leetcode.com/problems/balanced-binary-tree/
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
    boolean res;
    public boolean isBalanced(TreeNode root) {
        res = true;
        helper(root);
        
        return res;
    }
    
    int helper(TreeNode root) {
        
        //base
        if(root == null) return 0;
        //logic
        if(root.left == null && root.right == null) return 1;
        
        int left =  helper(root.left);
        int right = helper(root.right);
        
        if(Math.abs(left - right) > 1) {
            res = false;
        }
        
        return 1 + Math.max(left,right);
        
    }
}