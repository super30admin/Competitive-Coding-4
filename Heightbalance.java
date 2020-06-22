//Time Complexity:O(n)
//Space complexity: O(h)

class Solution {
    boolean flag=true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return flag;
    }
    
    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        if(Math.abs(left-right)>1){
            flag=false;
        }
        return 1+Math.max(left,right);
    }
}