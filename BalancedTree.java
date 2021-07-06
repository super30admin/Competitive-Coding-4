class Solution {
    public boolean isBalanced(TreeNode root) {
        
        int lh;
        int rh;
        
        if(root == null)
            return true;
        
        lh = height(root.left);
        
        rh = height(root.right);
        
        int dif = Math.abs(lh - rh);
        
        if(dif <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        
        return false;
        
        
    }
    
    
    private int height(TreeNode root){
        
        if(root == null)
            return 0;
        //System.out.println(root.val);
        
        return 1 + Math.max(height(root.left), height(root.right));
        
        
    }
}