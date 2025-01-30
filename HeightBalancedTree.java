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
    boolean isB = true;
    // Time Complexity: O(N)
    // Space Complexity: O(H)
    public boolean isBalanced(TreeNode root) {
       if (root == null){
        return true;
       } 
    //    int h1 = getHeight (root.left, 1);
    //    int h2 = getHeight (root.right, 1);
        int h1 = dfs (root.left, 1);  
        int h2 = dfs (root.right, 1);  

        if (Math.abs(h1-h2) >1){
            return false;
        }
        return isB;
    }
     public int dfs (TreeNode node, int h){
        if (node == null){
            return h-1;
        }
        int h1 = dfs (node.left, h+1);  
        int h2 = dfs (node.right, h+1); 
        if (Math.abs(h1-h2) >1){
            isB = false;
        }

            return Math.max (h1,h2);
     }
}