// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach : This solution is based on th edepth of a tree. We hunt for max depth and in the process if left and right children are separated by more than 1 levels, we return false
//LC 110

public class BalancedBinaryTree {
    private boolean result;

    public boolean isBalanced(TreeNode root) {

        result = true;

        depth(root);

        return result;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = depth(node.left);
        int right = depth(node.right);

        if (Math.abs(left - right) > 1) {
            result = false;
        }

        return Math.max(left, right) + 1;
    }

}


