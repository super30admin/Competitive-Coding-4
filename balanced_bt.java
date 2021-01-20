// Time Complexity : O(n)
// Space Complexity : O(h) h is height of recursive stack
// Did this code successfully run on Leetcode : Yes

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
    boolean isValid = true;
    public boolean isBalanced(TreeNode root) {
    int h = postorder(root);
    return isValid;    
    }
    
    private int postorder(TreeNode root){
        if(root == null)
            return 0;
        int leftheight = postorder(root.left);
        int rightheight = postorder(root.right);
        if(Math.abs(leftheight - rightheight) > 1){
            isValid = false;
        }
        return Math.max(leftheight, rightheight) + 1;
    }
}