/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Time complexity: O(nlogn)
//Space complexity: O(1)
class Solution {
    private int height(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left), height(root.right));
        
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int h= Math.abs(height(root.right)- height(root.left));
        if(h<2)
        {
            if(isBalanced(root.left) && isBalanced(root.right))
                return true;
            else
                return false;
        }
        else
            return false;
    }
}