// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {

        if(root == null) return true;
        return height(root) != -1;
    }
    
    private int height(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left == null && root.right == null) return 1;
        
        int left = height(root.left);
        int right = height(root.right);
        
        if(left == -1 || right == -1) return -1;
        int diff = Math.abs(left - right);
        
        if(diff >=2 ) return -1;
        
        return Math.max(left, right) + 1;
    }
}
