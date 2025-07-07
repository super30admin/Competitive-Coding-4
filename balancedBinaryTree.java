class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left = depth(root.left);
        int right = depth(root.right);

        if (Math.abs(left - right) > 1) return false;
        boolean leftR = isBalanced(root.left);
        boolean rightR = isBalanced(root.right);
        return leftR && rightR;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int leftH = depth(node.left);
        int rightH = depth(node.right);
        return Math.max(leftH,rightH) + 1;
    }
}
