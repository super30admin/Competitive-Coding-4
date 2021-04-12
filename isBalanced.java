/*
Run time complexity - O(N) where n is the number of elements in the array
Space complexity - O(H) where H is the Height of the tree for the recursive stack.
*/


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
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getheight(root)!=-1;
    }
    public int getheight(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=getheight(root.left);
        int right=getheight(root.right);
        if(left==-1 || right==-1||Math.abs(left-right)>1)
            return -1;
        return Math.max(left,right)+1;
    }
}
