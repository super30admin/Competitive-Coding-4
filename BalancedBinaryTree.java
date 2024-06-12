// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    private int checkHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight) + 1;

    }
}