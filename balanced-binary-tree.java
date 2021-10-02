//Time complexity: O(n)
//Space complexity: O(n)
class Solution {
    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        //get the height of the left child
        int left = height(root.left);
        if(left == -1) {
            return -1;
        }
        //get the height of the right child
        int right = height(root.right);
        if(right == -1 || Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
}