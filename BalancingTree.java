class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
         if( isBalanced(root.left) == false || isBalanced(root.right) ==false){
             return false;
         }
        int hleft = helper(root.left);
        int hright = helper(root.right);
        int diff = Math.abs(hright-hleft);
        if(diff>1){
            return false;
        }
        
        return true;
        
    }
    private int helper( TreeNode root ){
        
        if(root == null) return 0;
        
        int l = helper(root.left);
        int r = helper(root.right);
        int max = Math.max(l,r);
        return max+1;
    }
}