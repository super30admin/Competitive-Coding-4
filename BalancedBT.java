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
// Time Complexity : O(n) where n is total no of nodes
// Space Complexity : O(h) where h is the height of the tree which, space for recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.

class BalancedBT {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        recursion(root);
        return flag;
    }

    public int recursion(TreeNode root){
        //base
        if(root==null){
            return -1;
        }
        int leftheight = recursion(root.left);
        int rightheight = recursion(root.right);
        if(Math.abs(leftheight-rightheight) > 1){
            flag = false;
        }

        return 1+Math.max(leftheight, rightheight);
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }