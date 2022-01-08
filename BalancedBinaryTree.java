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
Time complexity : O(N) N. = number of nodes in tree
Space complexity : O(1)
recursive Space complexity : O(H) H = height of tree
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        return isHeightBalanced(root) != -1;
    }
    
    
    private int isHeightBalanced(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        
        // check left_height
        
        int left_height = isHeightBalanced(node.left);
        // check right height
        int right_height = isHeightBalanced(node.right);
        
        
        // if any of the left or right subtree is not height balanced we would have
        // returned -1 
        if(left_height == -1 || right_height == -1) {
            return -1;
        }
        
        // else check if height difference of current left and right tree is greater than 1 or 
        // not if it is larger than 1 return -1 as this tree is not height balanced 
        // else return height 
        
        if(Math.abs(left_height-right_height) > 1) {
            return -1;
        }else{
            // return height
            return 1 + Math.max(left_height, right_height);
        }
        
        
    }
}
