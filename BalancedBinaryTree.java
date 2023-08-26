public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (height(root) == -1)
            return false;
        return true;
    }
    public int height(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHight = height(root.right);
        if (leftHeight == -1 || rightHight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHight) > 1)
            return -1;

        return Math.max(leftHeight, rightHight) + 1;
    }
}
