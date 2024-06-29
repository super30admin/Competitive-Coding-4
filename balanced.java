// Time Complexity : o(N)
// Space Complexity : o(H)
// Did this code successfully run on Leetcode : yES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


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

        int difference = recurse(root);
        if(difference == -1){
            return false;
        }
        return true;
    }

    private int recurse(TreeNode root ){
        // base case
        if(root == null){
            return 0;
        }
        //left and right
        int left = recurse(root.left);
        int right = recurse(root.right);

        if( Math.abs(left - right) > 1 || left == -1 || right == -1){
            return -1;
        }
        
        return 1 + Math.max(right, left);
    }
}