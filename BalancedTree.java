class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if(root==null) return true;
        
        return isBalanced(root.left)  && isBalanced(root.right) && Math.abs(height(root.left)-height(root.right))<=1;
            
        
        
    }
    
    private int height(TreeNode root){
        if(root==null) return 0;
        else{
            return Math.max(height(root.left),height(root.right))+1;
        }
    }
}