/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Top down Recursive
// Time Complexity: O(n)
// Space Complexity with recursive stack: O(n)
 class Solution {
     boolean isBalanced = true;
     public boolean isBalanced(TreeNode root) {
         if(root == null) {
             return isBalanced;
         }
        helper(root);
         return isBalanced;
     }

     private void helper(TreeNode root) {
         if(root == null){
             return;
         }
         int l = height(root.left);
         int r = height(root.right);
         if(Math.abs(l-r)>1) {
             isBalanced = false;
         }
         helper(root.left);
         helper(root.right);
     }

     private int height(TreeNode root) {
         if(root == null) {
             return 0;
         }
         int left = height(root.left);
         int right = height(root.right);
         return 1 + Math.max(left, right);
     }
 }


// //Bottom up recursive
// // Time COmplexity: O(n)
// // Space Complexity with Recursive stack: O(maxDepth)
// // Space Complexity without recursive stack: O(1)
 class Solution {
     boolean isBalanced = true;

     public boolean isBalanced(TreeNode root) {
         if(root == null) {
             return true;
         }
         helper(root);
         return isBalanced;
     }

     private int helper(TreeNode root) {
         if(root == null) {
             return 0;
         }

         int left = helper(root.left);
         int right = helper(root.right);
         int diff = Math.abs(left-right);
         if(diff>1) {
             isBalanced = false;
         }
         return Math.max(left, right) + 1;
     }
 }

// Solution without global variables
class Solution {
    public boolean isBalanced(TreeNode root) {
        int h = dfs(root);
        if(h == -1) return false;
        return true;
    }
    private int dfs(TreeNode root)
    {
        //base
        if(root == null) return 0;
        //logic
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(l == -1) return -1;
        if(r == -1) return -1;
        int diff = Math.abs(l - r);
        if(diff > 1) return -1;
        return Math.max(l, r) + 1;
    }
}