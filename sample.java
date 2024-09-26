
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left_ht = get_ht(root.left);
        int right_ht = get_ht(root.right);
        if (Math.abs(left_ht - right_ht) > 1)
            return false;
        return (isBalanced(root.right) && isBalanced(root.left));

    }

    public int get_ht(TreeNode root) {
        if (root == null)
            return 0;
        int leftH = get_ht(root.left);
        int rightH = get_ht(root.right);
        return Math.max(leftH, rightH) + 1;
    }
}