// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        int left = 1 + height(root.left);	// find the height on the left side of the root
        int right = 1 + height(root.right);	// find the height on the right side of the root
        
        if(Math.abs(left - right) > 1){		// condition for the tree to height balanced
            return false;
        }
        
        
        return isBalanced(root.left) && isBalanced(root.right);	// go through both the sides to find the height of all levels
    }
    
    private int height(TreeNode root){		// recursively call the height function to find the height
        
        if(root == null){
            return 0;
        }
        
        int left = 1 + height(root.left);
        
        int right = 1 + height(root.right);
        
        if(left > right){		// return the height of th maximum side
            return left;
        }
        
        return right;
    }
}