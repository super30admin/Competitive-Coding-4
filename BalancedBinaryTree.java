// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isBalanced(TreeNode root) {
        // return true if tree is empty
        if(root == null) return true;
        // return false if height function returns -1
        return height(root) != -1;
    }
    private int height(TreeNode root){
        //base
        // return 0 in case of leaf node
        if(root == null) return 0;
        //logic
        // call the function recursively to get the left height and right height from a node
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        // if the difference between left and right side heights is greater than 1
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        // if the left or right height function of child node has returned -1
        if(leftHeight == -1 || rightHeight == -1) return -1;
        // return maximum of left height and right height incremented by 1
        return Math.max(leftHeight, rightHeight) + 1;
    }
}