// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int maxLeft = height(root.left);
        int maxRight = height(root.right);
        if(maxLeft > maxRight+1 || maxRight > maxLeft+1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
        
        
    }
    public int height(TreeNode node){
        if(node == null) return 0;
        return Math.max(height(node.left),height(node.right))+1;
    }
}
