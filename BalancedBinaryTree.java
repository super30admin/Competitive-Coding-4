public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        // null check
        if(root==null) return true;
        return helper(root)!=-1;
    }
    private int helper(TreeNode node){
        
        if(node==null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        
        int height = Math.abs(left-right);
        
        if(height>1 || left==-1 || right ==-1) return -1;
        return 1+Math.max(right,left);
    }
}

// Time Complexity - O(n)
// Space Complexity - O(h)
