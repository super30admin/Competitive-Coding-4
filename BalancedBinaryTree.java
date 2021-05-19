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

 
//Time Complexity: O(n);  n -> number of nodes
//Space Complexity: O(h); h -> height of the tree 

class Solution {
    public boolean isBalanced(TreeNode root) {
        //sanity check
        if(root == null){
            return true;
        }
        //find the diff b/w heights of left subtree and right subtree 
        //if diff > 1 then it is not a balanced binary tree
        if(Math.abs(height(root.left) - height(root.right)) > 1){
            return false;
        }

        //for tree to to balanced its subtrees should also be balanced
        //so check if its left subtree is balanced and rigth subtree is balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root){
        //edge cases
        if(root == null){
            return 0;
        }

        //height of the root node is max height of left subtree and right subtree plus 1
        return 1 + Math.max(height(root.left), height(root.right)); 
    }
}
