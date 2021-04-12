// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach
//-Use a flag integer variable to crosscheck teh height
//-Find the Maximum value of left and right subtree and add 1 to denote its height

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return helper(root) != -1;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        // recurse through left and right subtree
        int left = helper(root.left);
        // if its unblanced return -1
        if (left == -1)
            return -1;
        int right = helper(root.right);
        // if its unblanced return -1
        if (right == -1)
            return -1;

        // if the difference between left and right >1 then its unbalanced return -1
        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }
}