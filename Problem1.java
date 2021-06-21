// 110. Balanced Binary Tree

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
        
        if(root==null) 
            return true;

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left)-height(root.right))<=1;

   }

   private int height(TreeNode root)

   {
       if(root==null) return 0;

       else
           return Math.max(height(root.left),height(root.right))+1;

    }
}

/*
Complexity Analysis

Time complexity : 
O(nlogn) For a node p at depth d, height(p) will be called d times.

Space complexity : O(n). The recursion stack may contain all nodes if the tree is skewed.

*/