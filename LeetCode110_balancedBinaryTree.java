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
 //Travel all the nodes
 //At every node, calculate height by using next level's height+1
 //Check diff and make flag
 //return flag
 //TC: O(n);SC: O(h)
class Solution {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        this.flag=true;
        helper(root);
        return flag;
        
    }

    private int helper(TreeNode root){
        //
        if(root==null){
            return 0;
        }

        //
        int left=helper(root.left);
        int right=helper(root.right);

        if(Math.abs(left-right)>1){
            flag=false;
        }

        return Math.max(left,right)+1;
    }
}
