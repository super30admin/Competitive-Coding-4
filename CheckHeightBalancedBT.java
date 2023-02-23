/*
 * Time Complexity : O(n)
 * Space Complexity :  O(h)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - In this question we traverse till the entire entire recursively and check at each node if the height between it's left and right sub tree is greater than 1.
 * As we go down the tree, we add 1 to the height of the tree. And if at any node the height difference is greater than 1 then we send -1 to the root signalling that there is an inbalance.
 */

//https://leetcode.com/problems/palindrome-linked-list/

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
class CheckHeightBalancedBT {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        return helper(root) != -1;
    }

    private int helper(TreeNode root){
        if(root==null)return 0;
        int left=helper(root.left);
        int right=helper(root.right);
        if(Math.abs(left-right)>1)return -1;
        if(left == -1 ||right==-1)return -1;
        return Math.max(left,right)+1;
    }
}