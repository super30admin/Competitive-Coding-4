class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root ==null) return true;
        return height(root)!=-1;        
    }
    private int height(TreeNode root){
        if(root==null) return 0;
        int LH=height(root.left);
        int RH=height(root.right);
        if(Math.abs(LH-RH)>1) return -1;
        if(LH==-1||RH==-1) return -1;
        return Math.max(LH,RH)+1;
    }
}