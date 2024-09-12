// Time Complexity : O(n) n = total number of nodes
// Space Complexity : O(n) i.e. recursion stack to store the nodes in worst case i.e. tree is unbalanced/ skewed tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    private boolean isBalancedT = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null)    return true;
        
        maxDepth(root);
        
        return isBalancedT;
        
    }
    private int maxDepth(TreeNode root){
        if(root == null)    return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        if(Math.abs(left - right) > 1){
            isBalancedT = false;
        }
        
        return Math.max(left,right)+1;
    }
}
