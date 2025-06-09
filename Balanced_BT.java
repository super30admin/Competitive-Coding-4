// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
class Solution {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        flag = true;
        helper(root);
        return flag;
    }

    private int helper(TreeNode root){
        if(!flag) return 0;
        if(root == null) return 0;

        int Lheight = helper(root.left);
        int Rheight = helper(root.right);

        int diff = Math.abs(Lheight - Rheight);

        if(diff > 1) flag = false;

        return Math.max(Lheight, Rheight) + 1;
    }
}
