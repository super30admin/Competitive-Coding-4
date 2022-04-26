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

    // Time Complexity : 0(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I divided my tree into 2 parts. Left and right. Then I used DFS
    //to traverse my tree to the leaf. Then I returned the height of the tree. If height of left subtree and right subtree are
    //not same, then I return false. Else true.


    boolean status;
    public boolean isBalanced(TreeNode root) {
        status = true;
        helper(root);
        return status;
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if(Math.abs(left-right) > 1){
            status = false;
        }
        return 1 + Math.max(left,right);
    }
}