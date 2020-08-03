/**
Problem: Given a binary tree, return true if it is height balanced.
Did it run on LeetCode : Yes

Time Complexity : O(n), where n is the number of nodes in the tree
Space Complexity : O(h), where h is the height of the tree.

Approach:
1. The tree is height balanced if the left and right subtrees differ by a max height of 1.
2. So, we first do a DFS traversal to get the height of the left subtree.
3. Then, we do a DFS traversal to get the height of the right subtree.
4. In the end, we check if absolute difference between them is greater than 1. If it is greater, then it's not height balanced. Else, it is.



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
class Solution {
    int left, right;
    boolean isBalance = true;;
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            isBalance = true;
        }
        int result = dfs(root);
        return isBalance;
    }
    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        } 
        int left = dfs(root.left);       
        int right = dfs(root.right);
        if(Math.abs(left - right) > 1) {
            isBalance = false;
        }
        
        return Math.max(left, right) + 1;
    }
}