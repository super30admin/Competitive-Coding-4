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

//time-o(n)
//space- o(h)

//passed in leetcode- yes

class Solution {
    boolean isBalanced;
    
    public boolean isBalanced(TreeNode root) {
        
        isBalanced=true;
        int curht= helper(root,0);
        return isBalanced;
    }
    
    public int helper(TreeNode root, int currht)
    {
        if(root==null) return 0;
    
        if(root.left== null && root.right==null) return currht+1;
        
        int leftht = helper(root.left, currht);
        int rightht = helper(root.right, currht);
        
        if(Math.abs(leftht-rightht) >1)
        {
            isBalanced = false;
        }
        
        return Math.max(leftht,rightht)+1;
    }
}