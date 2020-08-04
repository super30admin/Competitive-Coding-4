/* Time complexity: O(n)
space complexity: O(1)  */

class Solution {
    boolean flag;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int result = calcheight(root);
        return !flag;
    }
    public int calcheight(TreeNode root){
        if(root == null) return 0;
        int left = calcheight(root.left);
        int right = calcheight(root.right);
        if(Math.abs(left-right) > 1) flag = true;
        return 1+Math.max(left, right);
    }
}