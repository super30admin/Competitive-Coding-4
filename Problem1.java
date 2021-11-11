// Time O(n2)
// space O(1)
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        
        
        int heightOfLeftTree = helper(root.left);
        int heightOfRightTree = helper(root.right);
        
        if(Math.abs(heightOfLeftTree -heightOfRightTree ) <= 1)
        {
            return  isBalanced(root.left) && isBalanced(root.right) ;
        }else
        {
            return false;
        }
        
       
        
    }
    
    private int helper(TreeNode root){
        
        if(root == null){
            return 0;
        }
        
       int leftTree = helper(root.left);
        
       int rightTree = helper(root.right);
        
     return 1 + Math.max(leftTree, rightTree);
    
    }
}