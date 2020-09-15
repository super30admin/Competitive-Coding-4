// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// At every node, find it's left and right sub trees are a valid balanced trees, and check for the condition of left and right subtree's heights (<=1)
// Using recrsion we can find this at every node and also under that one more recursion for returning heights of respective trees.
// Incrementing the height from the bottom to up by adding 1 at every level.
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

        if(root == null){
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right))<=1;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+ Math.max(height(root.left), height(root.right));
    }

}