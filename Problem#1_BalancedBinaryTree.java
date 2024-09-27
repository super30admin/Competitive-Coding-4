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
/*
 * Space complexity: O(1) constnt space used here
 * Time complexity: O(N)
 * */
class Solution {
    public boolean isBalanced(TreeNode root) {
        //Edge case when root is null
        if(root == null) return true;
        
        if(Math.abs(helper(root.left)-helper(root.right))>1) return false;
        // else if(isBalanced(root.left) && isBalanced(root.right)){
            // return true;
        // }
        return (isBalanced(root.left) && isBalanced(root.right));
    }
    
    private int helper(TreeNode node){
        if(node==null){
            return 0;
        }

        return Math.max(helper(node.left), helper(node.right))+1;
    }
}