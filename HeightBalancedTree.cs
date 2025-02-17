// time COmplexity - O(n)
// space COmplexity - O(1)
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
public class Solution
{
    public bool IsBalanced(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }
        return height(root) != -1;
    }
    public int height(TreeNode root)
    {
        // base
        if (root == null)
        {
            return 0;
        }

        //logic
        int left = height(root.left);
        int right = height(root.right);
        if (Math.Abs(left - right) > 1)
        {
            return -1;
        }
        if (left == -1 || right == -1)
        {
            return -1;
        }
        return Math.Max(left, right) + 1;
    }
}