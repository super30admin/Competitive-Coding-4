// Time Complexity : O(n), where n is the number of nodes in the binary tree.
// Each node is visited once to compute its height.

// Space Complexity : O(h), where h is the height of the tree (due to recursion stack).
// In worst case (unbalanced tree), it can be O(n), and in best case (balanced tree), O(log n).

// Did this code successfully run on Leetcode : Yes

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
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        
        this.flag = true;
        helper(root);
        return flag;
    }

    int helper(TreeNode root){
        if( root == null || flag == false) return 0;

        // logic
        // System.out.println("left  :" + left);
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left - right) > 1){
            flag = false;
        }
        return Math.max(left,right) + 1;
    }
}
