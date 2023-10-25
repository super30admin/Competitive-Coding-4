// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class BalancedBinaryTree {
    class Solution {
        private boolean flag;
        public boolean isBalanced(TreeNode root) {
            flag = true;
            helper(root);
            return flag;
        }

        private int helper(TreeNode root){
            if(root == null){
                return 0;
            }

            int leftHeight = helper(root.left);
            int rightHeight = helper(root.right);

            if(Math.abs(leftHeight - rightHeight) > 1){
                flag = false;
            }

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
