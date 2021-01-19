//Time Complexity: O(N)
//Space Complexity: O(H) H is the height of the tree in recursive stack
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
      Boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
      helper(root);
        return isBalanced;
    }
    private int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int L = helper(node.left);
        int R = helper(node.right);
        if(Math.abs(L-R)>1){
            isBalanced = false;
        
    }return Math.max(L,R)+1;
    }
}