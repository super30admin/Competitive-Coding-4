// https://leetcode.com/problems/balanced-binary-tree/submissions/
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

//  Time Complexity: O(n)
//  Space Complexity: O(h) 
class Solution {
    boolean ans;
    public boolean isBalanced(TreeNode root) {
        this.ans = true;

        if(root == null || (root.left == null && root.right == null)) return true;
        height(root);
        return ans;
    }


    public int height(TreeNode root){
        if(root == null) return 0;
        int leftHeight = height(root.left) + 1;
        int rightHeight = height(root.right)  + 1;
        ans = ans && Math.abs(leftHeight - rightHeight) <= 1;
        return Math.max(leftHeight, rightHeight);
    }
}
