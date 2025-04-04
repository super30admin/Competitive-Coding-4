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
 
 //TC: O(n)
 //SC: O(n)
 
class Solution {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        this.flag = true;
        int height = helper(root, 0);
        return flag;
    }

    public int helper(TreeNode root, int level){
        if(root == null) return level;

        level++;
        int leftHt = helper(root.left, level);         
        int rightHt = helper(root.right, level);
        //System.out.println(leftHt + " : " + rightHt);
        int diffHt = Math.abs(leftHt - rightHt);
        if(diffHt != 0 && diffHt != 1){
            flag = false;
        }
        return Math.max(leftHt, rightHt);
    }
}