//TC: O(n)

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
        if(root == null) return true;
        return height(root) != -1;
        
    }
    
    private int height(TreeNode root){
        //base
        if(root == null) return 0;
        
        //logic
        int LH = height(root.left);
        int RH = height(root.right);
        
        if(Math.abs(LH-RH) > 1) return -1;
        if(LH == -1 || RH == -1) return -1; //height check subnodes are not balanced
        
        return Math.max(LH,RH) + 1;
 
    }
}