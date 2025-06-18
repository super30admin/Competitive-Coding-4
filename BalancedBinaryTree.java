class Solution {
    public boolean isBalanced(TreeNode root) {

        return helper(root)!=-1;
        
    }

    private int helper(TreeNode root){
        //base
        if(root==null) return 0;
        //logic
        int left = helper(root.left);
        if(left==-1) return -1;
        int right= helper(root.right);
        if(right==-1) return -1;
        if(Math.abs(left-right)>1) return -1;

        return Math.max(left,right)+1;
    }
}