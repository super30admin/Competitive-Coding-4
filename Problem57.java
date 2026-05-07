// Time Complexity : O(N)
// Space Complexity : O(h)

class Solution {
    private int leftResult;
    private int rightResult;
    private boolean flag;
    public boolean isBalanced(TreeNode root) {
        this.leftResult = 0;
        this.rightResult = 0;
        this.flag = true;
        helper(root);
        return this.flag;
    }

    private int helper(TreeNode root) {
        //base
        if (root == null) return 0;

        int left = helper(root.left);
        if (left == -1) {
            return -1;
        } 
        int right = helper(root.right);
        if (right == -1) {
            return -1;
        }
        //logic
        int diff = Math.abs(left - right);
        if (diff > 1) {
            this.flag = false;
            return -1;
        }
        return 1+Math.max(left, right);
    }
}