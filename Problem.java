/*
Time COmplexity -> O(N)
Space COmplexity -> O(H)
*/



class Solution {
    boolean balanceFlag;
    public boolean isBalanced(TreeNode root) {
        balanceFlag = true;
        height(root);
        return balanceFlag;
    }
    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if(Math.abs(lh - rh) > 1) {
            balanceFlag = false;
        }
        return 1 + Math.max(lh,rh);
    }