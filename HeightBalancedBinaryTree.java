/*
Thought Process: 
Find height of left subtree, height of right sub tree and check if its less than 2, it is balalced. Use DFS approach.

TC -> O(N) where N is total number of nodes
SC -> O(1) constant space as we don't use any storage vars.
*/

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
class HeightBalancedBinaryTree {
    Boolean result = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        postOrder(root, 1);
        return result;
    }
    
    public int postOrder(TreeNode root, int h){
        if(root == null) return 0;
        int hl = postOrder(root.left, h);
        int hr = postOrder(root.right, h);
        
        if(Math.abs(hl-hr) > 1) 
            result = false;
        
        return Math.max(hl, hr) + 1;
    }
}