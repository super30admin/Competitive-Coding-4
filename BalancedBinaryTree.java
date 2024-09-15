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
/**
 * Time Complexity = O(N)
 * Space Complexity = O(N)
 * LeetCode: Y (https://leetcode.com/problems/balanced-binary-tree)
 * Approach: 
 *  Traverse the tree in a DFS way. 
 *  Return a positive height to the caller if and only if that subtree is balanced
 *  Return -1 to the parent if any of the nodes in the nodes in that parent's descendants is NOT balanced
 *  ultimately at the root the return value will be -1 if the tree is NOT balanced at any of the nodes 
 *  ultimately at the root the return value will be the height of the tree if the tree is balanced
 */
class Solution {
    private int checkBalanced(TreeNode root) {
        // Base Condition
        if(root == null) {
            return 0;
        }
        // Get left subtree height
        int leftSubTreeHeight = checkBalanced(root.left);
        // If any of the nodes in the left subtree is NOT balanced then return -1
        if(leftSubTreeHeight == -1) {
            return -1;
        }
        
        // Get right subtree height
        int rightSubTreeHeight = checkBalanced(root.right);
        // If any of the nodes in the right subtree is NOT balanced then return -1
        if(rightSubTreeHeight == -1) {
            return -1;
        }
        
        // If all the nodes in left and right subtree are balanced then check if the current node is balanced.
        // If the current node is not balanced then return -1
        if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
            return -1;
        }
        
        // If all the descendant nodes and current node are balanced then return the actual height
        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }
    public boolean isBalanced(TreeNode root) {
        // Any non-negative number is a valid height(Balanced)
        // Return value of -1 denotes that the binary tree is not balanced
        return (checkBalanced(root) >= 0);
    }
}
