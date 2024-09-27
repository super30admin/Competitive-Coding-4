// Time Complexity - O(n)
// Space Complexity - O(h)

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
    private int countLeft = 0;
    private int countRight = 0;
    private boolean flag;
    public boolean isBalanced(TreeNode root) {
        flag = true;
        helper(root);
        return flag;

    }

    private int helper(TreeNode root){
        // base
        if(root == null) return 0;

        int left = helper(root.left);
    
        int right = helper(root.right);
        if(Math.abs(right-left)>1){
            flag = false;
        }
        return Math.max(left,right) + 1;
    }
}