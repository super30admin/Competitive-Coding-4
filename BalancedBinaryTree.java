// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

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
        //if(root == null) return true;
        helper(root);
        return flag;
    }
    private int helper(TreeNode node){
        //base
        if(node == null) return 0;
        //logic
        int l = helper(node.left);
        int r = helper(node.right);
        if(Math.abs(l-r)>=2) flag = false;
        int height = 1+ Math.max(l,r);
        return height;
    }
}
