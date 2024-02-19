// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int lefth = helper(root.left);
        int righth = helper(root.right);
        return Math.abs(lefth - righth) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }
     private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lefth = helper(node.left);
        int righth = helper(node.right);
        return 1 + Math.max(lefth, righth);
    }
}