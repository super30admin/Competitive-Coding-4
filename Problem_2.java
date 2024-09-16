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
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//bottom-up recursion while keeping count of height at every node and checking with its other side 
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left)-height(root.right))<=1;
    }
    private int height(TreeNode root){
        if(root==null) return 0;
        else return Math.max(height(root.left),height(root.right))+1;
    }
}