class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root.left==null && root.right==null) return true;
        return  isBalanced(root.left) && isBalanced(root.right) 
            && Math.abs(height(root.right,0)-height(root.left,0))<=1;
    }
    
    
    
    public int height(TreeNode root,int hieght){
         if(root.left==null && root.right==null) return hieght;
        return Math.max(height(root.left,hieght+1),height(root.right,hieght+1)) ;
    }
    
    
}
