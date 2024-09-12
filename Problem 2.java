//Time Complexity: O(N) where N is the number of TreeNodes
//Space Complexity: O(h) where h is the height of the tree and if we consider recursive stack space

//Successfully runs on leetcode: 1 ms

//Approach: We start from the leaf nodes to find the maximum depth on each left subtree as well as right subtree and check 
//if the difference in their depths is greater than 1 - if yes, its not a height balanced tree and we return false


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
        if(root == null) return true;
        isValid = true;
        int depth = helper(root);
        return isValid;
    }
    
    private int helper(TreeNode root)
    {
        //base
        if(root == null) return 0;
        
        //logic
        
        int l = helper(root.left);
        int r = helper(root.right);
        
        if(Math.abs(l-r) > 1)
            isValid = false;
        
        return Math.max(l,r)+1;
    }
}