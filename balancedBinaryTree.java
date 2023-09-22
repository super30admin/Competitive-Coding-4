// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Recursively find the height of left and right subtree
 * 2. If the difference is greater than 1, set the result to false
 * 3. Return the height of the tree
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        boolean[] result = new boolean[]{true};
        helper(root, result);
        return result[0];
    }

    private int helper(TreeNode root, boolean[] result){
        if(root == null){
            return 0;
        }

        int left = helper(root.left, result);
        int right = helper(root.right, result);

        if(Math.abs(left-right) > 1){
            result[0] = false;
        }

        return 1 + Math.max(left, right);
    }
}