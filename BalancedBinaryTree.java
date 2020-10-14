// Time Complexity : O(N) - As we traverse through every node in the tree
// Space Complexity : O(N) - Internal stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    public int height(TreeNode root){
        if(root == null) return -1;
        if(root.left == null && root.right == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(left > right) return left + 1;
        else{
            return right + 1;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        else{
            if(Math.abs(height(root.left) - height(root.right)) > 1) return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
// Your code here along with comments explaining your approach
