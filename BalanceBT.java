// Time - O(n) - as we go through all nodes in the tree
// Space - O(h) - h = height of stack

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left)-height(root.right))<=1;
    }
    
    private int height(TreeNode root) {
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
}class BalanceBT {
    
}