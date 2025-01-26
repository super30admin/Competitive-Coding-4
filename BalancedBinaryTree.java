// In this problem we are using bottom up approach, calculating the height of child node and return that to its parent node. Then check 
// the difference between the heights of left and right subtree, then if the difference is greater than 1, it is unbalanced. 

// Time Complexity : O(n) - no. of nodes
// Space Complexity : O(h) - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean isBalanced(TreeNode root) {
        // If root is null, it is balanced
        if (root == null) {
            return true;
        }
        // Call the method and check if the output is -1 that means unbalanced
        return balanceCheck(root) != -1;
    }

    private int balanceCheck(TreeNode root) {
        // If root is null, that means we are at leaf node, return height 0 for leaf
        // node
        if (root == null) {
            return 0;
        }
        // Go left until it is leaf node
        int left = balanceCheck(root.left);
        // Once you complete this call, check if the height returned is -1? yes than
        // unbalanced
        if (left == -1) {
            return -1;
        }
        // Go right until it is leaf node
        int right = balanceCheck(root.right);
        // Once you complete this call, check if the height returned is -1? yes than
        // unbalanced
        if (right == -1) {
            return -1;
        }
        // After both calls complete, check difference between height of left and right
        // is >1, yes than unbalanced
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        // Else return the height of children +1 to parent
        return Math.max(left, right) + 1;
    }
}
