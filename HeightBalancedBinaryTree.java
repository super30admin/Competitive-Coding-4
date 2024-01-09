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
//DFS solution

TC: O(n)
sc: O(h)
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true; 
        //calculate height
        int h = Math.abs(findHeight(root.left) - findHeight(root.right));
        if( h > 1) 
            return false;
        return isBalanced(root.left) && isBalanced(root.right);   
    }
    public int findHeight(TreeNode root){
        if(root == null) 
            return 0;        
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }
  }

