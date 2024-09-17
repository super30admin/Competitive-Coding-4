/*
Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    private boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        
        
        height(root);
        return this.ans;
        
    }
    
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(Math.abs(lh - rh) > 1){
            this.ans = false;
            return 0;
        }
        
        return (Math.max(lh, rh) + 1);
    }
}
