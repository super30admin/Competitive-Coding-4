// Time Complexity : O(n)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// Approach

// Used recursive approach
// checked if the height diff of subtrees is less than 2
// Another recursive function for getting height

class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);

    }

    public int height(TreeNode root) {
        if (root == null)
            return -1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

}