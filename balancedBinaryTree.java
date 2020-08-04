//time complexity: O(n) where n is the number of nodes in the tree
//space complexity : O(max height of the tree)
//executed on leetcode: yes
//approach: we use bottom up recursion to fetch height values at a particular root and if this subtree is balanced binary tree, we keep on doing this till we reach the root
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
        if(root==null) return true;
        if(Math.abs(height(root.left)-height(root.right))>1) return false; //this means that the subtree is not balanced binary tree
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root)
    {
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1; // add 1 as we need to include the root node as well
    }
}