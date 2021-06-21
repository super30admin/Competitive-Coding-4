// TC: O(n)
// SC: O(h)
class Solution {
    boolean result = true;
    private int helper(TreeNode root, int height) {
        if(root == null) {
            return 0;
        }
        int leftHeight = helper(root.left, height);
        int rightHeight = helper(root.right, height);
        if(Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        helper(root, 0);
        return result;
    }
}