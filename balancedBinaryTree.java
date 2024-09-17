// Time Complexity = O(n)
// Space Complexity = O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
// This is a bottom up approach, where we go to the leaf node and add up heights till the root node, and if we find some mismatch at some node on the way we return false.
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (height(root) == -1)? false: true;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        // Go to the left node and get its height
        int left = height(root.left);

        // Go to the right node and get its height
        int right = height(root.right);

        // Check if either left or right nodes return a -1 or if the difference of left and right is greater than 1
        if (left == -1 || right == -1 || Math.abs(left-right) > 1) {
            return -1;
        }

        // Return max(left, right)+1, which indicates we are reporting to the upper node the height of max of lower nodes and current node
        return Math.max(left, right) + 1;
    }
}