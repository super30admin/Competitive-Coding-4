// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree due to recursion stack

// Your code here along with comments explaining your approach:
// Used a bottom-up recursive function that calculates the height of each subtree.
//If it finds that the height difference between the left and right subtree is greater than 1, it returns -1 i.e. the tree is unbalanced.
//If either subtree is already unbalanced (returns -1), it stops further checks.
//Otherwise, it returns the current node's height as max(left, right) + 1.


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
        if(helper(root) == -1){
            return false;
        }else{
            return true;
        }

    }

    public int helper(TreeNode root){

        if(root == null) return 0;

        int height_left = helper(root.left);
        if(height_left == -1) return -1;

        int height_right = helper(root.right);
        if(height_right == -1) return -1;

        if(Math.abs(height_left - height_right) > 1) return -1;

        return Math.max(height_left, height_right)+1;

    }



}