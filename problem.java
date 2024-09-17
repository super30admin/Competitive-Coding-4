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
//TC: O(n)
//SC: O(height)

class Solution {
    public boolean isBalanced(TreeNode root) {
        //base case
        if (root == null)  return true;
        
		if (calculate_height(root) == -1)  return false;
		return true;
	}
	public int calculate_height(TreeNode root) {
		if (root == null)  return 0;
        
		int leftHeight = calculate_height(root.left);
		int rightHight = calculate_height(root.right);
        
		if (leftHeight == -1 || rightHight == -1)  return -1;
        
        if (Math.abs(leftHeight - rightHight) > 1)  return -1;
        
		return Math.max(leftHeight, rightHight) + 1;
    }
}
