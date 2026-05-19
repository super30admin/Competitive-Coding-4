// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    bool balanced;
    public bool IsBalanced(TreeNode root) {
        balanced = true;
        Helper(root);
        return balanced;        
    }

    public int Helper(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }

        int leftSubtree = Helper(root.left);
        int rightSubtree = Helper(root.right);

        if(Math.Abs(leftSubtree-rightSubtree) > 1)
        {
            balanced = false;
        }

        return Math.Max(leftSubtree,rightSubtree) + 1;
    }
}