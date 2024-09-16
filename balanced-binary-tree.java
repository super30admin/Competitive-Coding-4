// Time - O(N)
// Space - O(H), worst H = N

class Solution {
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        
        if(root == null) {
            return true;
        }
      
        helper(root);
        return result;
    }
    
    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
          
        int lh = helper(root.left);
        int rh = helper(root.right);
        
        if(Math.abs(lh - rh) > 1) {
            result = false;
            return -1;
        }
        
        return Math.max(lh, rh) + 1;
    }
}
