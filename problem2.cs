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
    public bool IsBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.Abs(Height(root.left)-Height(root.right))>1) return false;
        return IsBalanced(root.left) && IsBalanced(root.right);
        
    }
    int Height(TreeNode root)
    {
        if(root == null) return 0;
        return Math.Max(Height(root.left),Height(root.right))+1;
    }
}