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

// Time Complexity: O(n) as we are returning the function callas soon as we find unbalanced at any root rather than checking all the lefts and rights.
// Space complexity: O(1) no additional data structure used
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach here
// Idea here is to recurse to the left most leaf and while coming back to the parent
// if at any point the parent root is unbalanced, return false
// else recurse to right and check parent depth using height formula
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return height(root) !=-1;
    }
    
    public int height(TreeNode root) {
        if(root==null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1) return -1;
        if(left==-1 || right==-1) return -1;
        return Math.max(left, right)+1;
    }
}