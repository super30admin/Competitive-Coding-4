package Nov15;

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
class BalancedBinaryTree {
    
    boolean result = true;
    
    public boolean isBalanced(TreeNode root) {
       
/*
       
     O(n) time complexity because we are visiting all nodes to check height and then do the comparison
    
     O(h) space complexity because recursive stack will have all elements along the max height of the tree in worst case. If it is a skewed tree where all nodes are towards the left, then h will be equal to n.
   
     Did this code successfully run on Leetcode : Yes
    
     Any problem you faced while coding this : No
     
     Approach: 
     DFS approach taken to calculate height of left and right subtree and then find diff of both to check if it is not more than 1. We start calculating heights from leaf nodes towards root such that at any point height of left subtree and right subtree shouldn't be greater than 1. If it is > 1, we set result boolean variable to false.
    
        
*/
        // Edge case
        if (root == null) {
            return true;
        }
        
        calcHeight(root);
        return result;
       
    }
    
    // helper function to calculate heights of left and right subtrees and then find their diff to check if it is > 1 or not.
    public int calcHeight(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int lh = calcHeight(root.left);
        int rh = calcHeight(root.right);
        
        if (Math.abs(lh-rh) > 1) {
            result = false; 
        }
        
        return Math.max(lh, rh)+1;
        
    }
    
}