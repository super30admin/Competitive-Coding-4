// Time Complexity : O(n).
// Space Complexity : O(h) - recursive stack memory where h is the height of the tree.
// Did this code successfully run on Leetcode : Yes
// Approach : The approach is to find height at each node and check if the left and right node's heights absolute difference is greater than 1, which means
//tree is not balanced.


class Solution {
    Boolean output = true;
    public boolean isBalanced(TreeNode root) {
        helper(root); //recursive function to calculate height and check if they balanced at each node.
        return output;
    }

    private int helper(TreeNode root){
        //base case
        if(root == null){
            return 0;
        }

        //logic
        int left = helper(root.left);
        int right = helper(root.right);

        if(Math.abs(left - right) > 1){ //checking left and right node's absolute value
            output = false;
        }

        int height = 1 + Math.max(left, right); //height calculation
        return height;
    }
}