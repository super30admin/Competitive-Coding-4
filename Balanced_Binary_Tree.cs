using System;
namespace Algorithms
{
    public class Balanced_Binary_Tree
    {
        /// Time Complexity : O(NLogN) 
        // Space Complexity :O(1) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        public bool IsBalanced_Recusion(TreeNode root)
        {
            if (root == null) return true;
            if (Math.Abs(height(root.left) - height(root.right)) > 1) return false;
            return IsBalanced_Recusion(root.left) && IsBalanced_Recusion(root.right);
        }

        private int height(TreeNode root)
        {
            if (root == null) return 0;

            return Math.Max(height(root.left), height(root.right)) + 1;
        }



        /// Time Complexity : O(N) 
        // Space Complexity :O(1) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        public bool IsBalanced(TreeNode root)
        {
            if (root == null) return true;
            return height(root) != -1;
        }

        private int height_New(TreeNode root)
        {
            if (root == null) return 0;
            int left = height(root.left);
            int right = height(root.right);
            if (Math.Abs(left - right) > 1) return -1;
            if (left == -1 || right == -1) return -1;
            return Math.Max(left, right) + 1;
        }
    }
}
