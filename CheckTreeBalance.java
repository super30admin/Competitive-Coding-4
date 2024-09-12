//Time complexity:O(N)
//Space complexity: O(1)
//Executed on leetcode.

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
    
boolean isBal = true;
    public boolean isBalanced(TreeNode root)
{
	if(root == null)
		return true;
		
	dfs(root);
	
	return isBal;
}

private int dfs(TreeNode root)          //Coming from the leaf to root. If left subtree height and right subtree height is more than 1 returing false, else true.
{
	if(root==null)
		return 0;
	int left = dfs(root.left);
	int right = dfs(root.right);
	if(Math.abs(left-right)>1)
		isBal= false;
	return 1+Math.max(left,right);
	
}
}