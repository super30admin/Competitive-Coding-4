/**
Problem: https://leetcode.com/problems/balanced-binary-tree/
TC: O(n)
SC: O(1)
*/
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
        if (root == null) {
            return true;
        }
        
        if (traverse(root) == -1) {
            return false;
        }
        return true;
    }
    
    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int LH = traverse(root.left);
        if (LH == -1) {
            return -1;
        } 
        
        int RH = traverse(root.right);
        if (RH == -1 || Math.abs(LH - RH) > 1) {
            return -1;
        }
        
        return 1 + Math.max(LH, RH);
    }
}