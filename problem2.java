//time- O(N)
//Space- O(N)

class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if(root==null) return true;
        
        int left_depth= helper(root.left);
        int right_depth= helper(root.right);
        
        if(Math.abs(left_depth- right_depth)>1) return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int helper(TreeNode root){
        
        if(root==null) return 0;
        
     return 1+ Math.max(helper(root.left), helper(root.right));

        
    }
}