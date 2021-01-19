// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Calculate the left and right height of each subtree check if it's valid every time the element is popped out from the stack.


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
    private boolean isValid;
    public boolean isBalanced(TreeNode root) {
        isValid=true;
        checkBalancedTree(root);
        return isValid;
    }
    
    private int checkBalancedTree(TreeNode node){
        if(node==null){
            return -1;
        }
        int left=1+checkBalancedTree(node.left);
        int right=1+checkBalancedTree(node.right);
        if(Math.abs(left-right)>1){
            isValid=false;
            return -1;
        }
        return Math.max(left,right);
    }
}