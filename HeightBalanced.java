// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
//Approach : In bottom up recursion use height calculated by child node and pass it to parent.
//keep checking if the tree is height balanced on each node.


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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        checkBalance(root);

        return balanced;
    }

    private int checkBalance(TreeNode node){
        //base
        if(node == null) return 0;

        int leftDepth = checkBalance(node.left);
        int rightDepth = checkBalance(node.right);

        if( Math.abs(leftDepth - rightDepth) > 1){
           balanced = false;
        }

        return 1 + Math.max(leftDepth, rightDepth);
    }
}