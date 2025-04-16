// Time Complexity : O(n)
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

// Approach :
// 1. Use post-order DFS to compute subtree heights recursively.
// 2. If height difference between left and right > 1, return -1 to indicate imbalance.
// 3. Return true in `isBalanced()` if DFS never returns -1.



public class balancedBinaryTree 
{
    public class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) 
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public class Solution 
    {
        public int balanced(TreeNode root,int height)
        {
            if(root == null)
            {
                return 0;
            }
            else
            {
                int left = 0;
                int right = 0;
                if(root.left != null)
                {
                    left = balanced(root.left,height+1);
                }
                if(root.right !=null)
                {
                    right = balanced(root.right,height+1);
                }
                if(left == -1 || right ==  -1)
                {
                    return -1;
                }
                if(Math.abs(right-left) >1)
                {
                    return -1;
                }
                return Math.max(left,right)+1;
            }
        }
        public boolean isBalanced(TreeNode root) 
        {
            int ar = 0;
            if(balanced(root,0) == -1)
            {
                return false;
            }
            return true;
        }
    }
}
