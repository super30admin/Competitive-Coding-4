//O(n) time and O(n) space

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int left = helper(root.left);
        int right = helper(root.right);

        if(left == -1 || right == -1)
            return false;
        return Math.abs(left-right)>1?false:true;
    }
    public int helper(TreeNode node){
        if(node==null)
            return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        if(left == -1 || right == -1 || Math.abs(right-left) > 1)
            return -1;
        return Math.max(left, right)+1;
    }
} 