class Solution {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        flag=true;
        dfs(root);
        return flag;
    }
    private int dfs(TreeNode root){
        if(root.left==null && root.right==null) return 1;
        int hl,hr;
        if(root.left!=null){
            hl=dfs(root.left);
        }
        else hl=0;

        if(root.right!=null){
            hr=dfs(root.right);
        }
        else hr=0;
        if(Math.abs(hr-hl)>1){
            flag=false;
        }
        return Math.max(hl,hr)+1;
    }
}
