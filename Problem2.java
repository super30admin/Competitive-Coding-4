/*
    LC - 110. Balanced Binary Tree
    TC - O(n)
    SC - O(1)
        recursive stack space
    Approach - 
        check if the height is not equal to -1.
        calculate the height of the tree from leaf to root.
        return -1 if abs diff is greater than 1.
        return -1 if anyone of the left, right is -1.
        
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return height(root) != -1;
    }
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1) return -1;
        if(left == -1 || right == -1) return -1;
        return Math.max(left, right) + 1;
    }
}