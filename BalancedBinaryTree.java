// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * The idea is to check each node if it is height balanced.
 * We calculate the height for each subtree and check the root node if it is height balanced.
 * We are setting a global variable false in case we encounter a breach of balanced height (Initially set to true)
 * Finally the result is false only when the tree is not height balanced at any subtree.
 */


public class BalancedBinaryTree {
    boolean result = true;
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int h = height(root);
        
        return result;
    }
    
    public int height(TreeNode root) {
        // base case
        if(root == null) return 0;

        int left_height = height(root.left);
        int right_height = height(root.right);
        
        if(Math.abs(left_height - right_height) > 1) {
            result = false;
        }

        return Math.max(left_height, right_height) + 1;
    }
}
