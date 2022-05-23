
/// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    boolean result;
    public boolean isBalanced(TreeNode root) {
        result = true;
        isBalancedTree(root);
        return result;
    }
    // we are following bottom up approach
    private int isBalancedTree(TreeNode root) {
        // when we hit the null pointer, we return zero
        // on leave node, we return Math.max(0,0) + 1 to left and right
        if(root == null) return 0;
        int left = isBalancedTree(root.left);
        int right = isBalancedTree(root.right);
        // when left or right diff is greater than 1,
        // tree is not balanced
        if(Math.abs(left-right) > 1) result = false;
        return Math.max(left,right)+1;
    }


}