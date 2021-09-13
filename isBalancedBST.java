// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

1. find height at each node ( a node is balanced if diff btw height of left and right subtree is less than 2) 
2. check difference keep checking it recursively.

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
        if(root == null)
            return true;
        //System.out.println(root.val);
        // if root is balanced or not 
        if(Math.abs(height(root.left) - height(root.right) ) > 1)
            return false;
        
        // if the other nodes(other subtrees) are balance or not 
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int height(TreeNode root)
    {
        if(root == null)
            return 0;
        
        return Math.max(height(root.left ) , height(root.right  ) ) +1;
    }
}