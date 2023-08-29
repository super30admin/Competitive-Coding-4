// TC O(n)
// SC 0(1)
// Binary tree is balanced if its left and right sub tree is balanced. Here we will calcaulte height
// 
class TreeBalance{
    public boolean isBalanced(TreeNode root){
        if(root = null) return true;
        if(Math.abs(height(root.left) && height(root.right))>1) return false; 
        return isBalanced(root.left) && is isBalanced(root.right);
    }
    private int height(TreeNode root){
        ///base
        if(root == null) return 0;
        return Math.max(height(root.right),height(root.left))+1;
    }
}