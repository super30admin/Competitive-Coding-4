//Accepted on LT
//Compare left height with right height and if anywhere the diff is more than 2 just change global variable
//Time should be O(n)
class Solution {
    int flag;
    public boolean isBalanced(TreeNode root) {
        this.flag = 0;
        helper(root);
        if(flag==-1) return false;

        return true;
        
    }

    public int helper(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        
        int l = helper(root.left) + 1;
        int r = helper(root.right) + 1;
        if(Math.max(l,r)-Math.min(l,r)>=2){
            flag = -1;
            return -1;
        }
        return  Math.max(l,r);
    }
}