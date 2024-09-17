// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None. 


// Your code here along with comments explaining your approach

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
		 if(root == null) return true;
		
		 return height(root) != -1;
	}
  
	public int height(TreeNode node){
		
		 if(node== null) return 0;
		
		 int left = height(node.left);
		 int right = height(node.right);
		 int value = Math.abs(left - right);
		
		 if(value > 1 || left == -1 || right == -1) return -1;
		 return 1 + Math.max(left,right);
	};
}