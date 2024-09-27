

// Time Complexity : O(N)
// Space Complexity : O(1)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int left=1+height(root.left);
        int right=1+height(root.right);
        
        if(Math.abs(left-right) > 1)
            return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int height(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int left=1+height(root.left);
        int right=1+height(root.right);
        
        if(left > right)
            return left;
        
        return right;
    }
}
