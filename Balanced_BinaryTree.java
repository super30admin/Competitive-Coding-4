// Time Complexity : O(n^2)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* A height balanced binary tree can be identified by 3 condition
 * difference between the left and the right subtree for any node is not more than one
 * the left subtree is balanced
 * the right subtree is balanced*/

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Balanced_BinaryTree {
	public boolean isBalanced(TreeNode root) {
		int leftHeight; // height of left subtree
		int rightHeight;    //height of right subtree

		if(root == null)
			return true;

		//get height of left and right subtrees
		leftHeight = height(root.left);
		rightHeight = height(root.right);

		if(Math.abs(leftHeight - rightHeight) <= 1
				&& isBalanced(root.left)
				&& isBalanced(root.right))
			return true;

		return false;
	}


	int height(TreeNode root){
		if(root == null)
			return 0;

		return 1 + Math.max(height(root.left), height(root.right));
	}
}

/*************************************Approach 2*******************************************/
//Time Complexity : O(n)
//Space Complexity : O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
	public boolean isBalanced(TreeNode root) {
		// calling helper for root, and getting height of tree is balanced, else returing -1 from helper
		int result = helper(root);

		return result == -1? false : true;
	}

	private int helper(TreeNode root){
		if(root == null)
			return 0;

		int left = helper(root.left);   
		int right = helper(root.right);

		if(left == -1 || right == -1 || Math.abs(left-right) > 1)
			return -1;

		return Math.max(left, right) + 1;
	}
}