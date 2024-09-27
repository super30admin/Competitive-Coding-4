// Time Complexity : O(n logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Check the height of left subtree and right subtree recursively
//Take absolute of these and see their difference
//If difference is more than one that means its not balanced, else it is balanced
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
        //height of left subtree
        if(root == null)
            return true;
        int hleft = height(root.left);
        //height of right subtree
        int hright = height(root.right);
        return (Math.abs(hleft - hright) < 2) && isBalanced(root.left) && isBalanced(root.right);
           
    }
    private int height(TreeNode root){
        if(root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}