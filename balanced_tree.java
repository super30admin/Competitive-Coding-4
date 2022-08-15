// Time Complexity :O(nlogn)
// Space Complexity : O(h) where h is height of tree log n

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        if(Math.abs(height(root.left)-height(root.right))>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int height(TreeNode root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        return 1+Math.max(height(root.left),height(root.right));
    }
}
