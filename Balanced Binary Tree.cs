/*
  Time complexity: O(n)
  Space complexity: O(h)

  Code ran successfully on Leetcode: Yes
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    bool flag = true;
    public bool IsBalanced(TreeNode root) {
        helper(root);
        return flag;
    }

    private int helper(TreeNode root)
    {
        if(root==null)
            return -1;

        if(flag)
        {
            int left = helper(root.left);
            int right = helper(root.right);

            if(Math.Abs(left-right)>1)
            {
                flag = false;
            }

            return Math.Max(left,right) + 1;
        }  
        return -1;

    }
}
