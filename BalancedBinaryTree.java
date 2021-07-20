Balanced Binary Tree110. Balanced Binary Tree

Given a binary tree, determine if it is height-balanced.

        For this problem, a height-balanced binary tree is defined as:

        a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

        Input: root = [3,9,20,null,null,15,7]
        Output: true

// Time Complexity : O(n)
// Space Complexity : O(H)
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
    boolean flag= true;
    public boolean isBalanced(TreeNode root) {

        if(root == null)
            return true;
        int height = 0;
        helper(root, height);
        return flag;
    }

    private int helper(TreeNode root, int height){
        //base
        if(root==null)
            return height;

        int leftHeight=0,  rightHeight=0, diff=0;

        //logic
        if(flag == true){
            leftHeight = helper(root.left, height+1);
            rightHeight = helper(root.right, height+1);


            diff = Math.abs(leftHeight-rightHeight);
        }
        if(diff>1){
            flag = false;
        }

        return Math.max(leftHeight, rightHeight);

    }
}