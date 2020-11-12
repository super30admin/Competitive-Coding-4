//Time Complexity : O(n)
//Space Complexity : O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

class Balanced_BinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(height(root.left) - height(root.right))<=1);
    }
    private int height(TreeNode root)
    {
        if(root == null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right)) + 1;
    }
}
