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
// Approch : Brute Force - Calculate height at each node first and then check if it is balanced or not
// Time : O(n^2)
// Space : O(n)
class Solution {
    public boolean isBalanced(TreeNode root) {
        // base case
        if(root == null) return true;

        // logic - Balanced Binary Tree - abs(height of left subtree - heigh of subtree) <=1
        // At every node
        if(Math.abs(height(root.left) - height(root.right))>1){
            return false;
        }
        // check if left sub tree is balanced
        // check if right sub tree is balanced
        return isBalanced(root.left) && isBalanced(root.right);
        
    }

    public int height(TreeNode root){
        // base case
        if(root == null) return 0;
        
        // logic
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
}

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


// Approch : Improved (Bottom Up Approach) - Instead of repeatedly calculating height at everynode. 
// Time : O(n)
// Space : O(n)
class Solution {
    public boolean isBalanced(TreeNode root) {
        // base case
        if(root == null) return true;
        // At any given time if height is -1 then somewhere down the tree any of the sub tree(left or right) is not balanced.
        return height(root) !=-1; 
    }

    public int height(TreeNode root){
        // base case
        if(root == null) return 0;
        
        // logic
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // if at any particular node if abs diff of heights > 1 return false to parent node
        if(Math.abs(leftHeight-rightHeight)>1 ) return -1;
        // During the process if any left subtree or right subtree returns -1 
        // then return height = -1 to parent
        if(leftHeight == -1 || rightHeight == -1) return-1;
        // else return original height to parent node
        return Math.max(leftHeight,rightHeight)+1;
    }
}