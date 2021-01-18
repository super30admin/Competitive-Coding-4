// Time Complexity : The time complexity is O(n) where n is the number of tree nodes
// Space Complexity : The space complexity if O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
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

    boolean balance;

    public boolean isBalanced(TreeNode root) {

        balance = true;

        if(root == null){
            return true;
        }

        if(root.left == null && root.right==null){
            return true;
        }

        dfs(root);

        return balance;

    }

    public int dfs(TreeNode root){

        // base case
        if(root == null){
            return 0;
        }

        // Height oh the left children
        int leftCount = dfs(root.left) + 1;
        // Height of the right children
        int rightCount = dfs(root.right) + 1;

        if(!balance){
            return 0;
        }

        // check for balance in tree
        if(Math.abs(leftCount-rightCount) > 1){
            balance = false;
        }

        return Math.max(leftCount,rightCount);

    }
}