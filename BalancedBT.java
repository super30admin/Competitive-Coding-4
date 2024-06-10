/***
 TC - O(n), SC - O(h)
 */

class Solution {

    public boolean isBalanced(TreeNode root) {

        if(root == null)
            return true;

        return (Math.abs(maxHeight(root.left) - maxHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right));

    }

    private int maxHeight(TreeNode root) {

        if(root == null)
            return 0;

        int left = maxHeight(root.left);
        int right = maxHeight(root.right);

        return Math.max(left, right) +1;

    }
}