public class BalancedTree
    {
        // Time Complexity : O(n)
        // Space Complexity : O(h)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No
        //Approach: Check the height at the children first
        //          If the height at children is not balanced, then return -1
        public bool IsBalanced(TreeNode root)
        {
            int height = helper(root);
            if (height == -1)
                return false;
            return true;
        }

        private int helper(TreeNode root)
        {
            if (root == null)
                return 0;

            int left = helper(root.left);

            int right = helper(root.right);

            if (left == -1 || right == -1 || Math.Abs(left - right) > 1)
                return -1;

            return Math.Max(left, right) + 1;

        }
    }
