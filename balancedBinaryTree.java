//110. Balanced Binary Tree
//TC: O(n)
//SC: O(n) we used recursive stack

class balancedBinaryTree {
    boolean isValid = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        height(root);
        return isValid;

    }
//Calculate the height if it's not less than 1 at any level it's not a balanced binary tree
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            isValid = false;
        }
        return Math.max(left, right) + 1;


    }

}