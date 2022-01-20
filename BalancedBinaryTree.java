package competitveCoding4;

public class BalancedBinaryTree {
	public class TreeNode {
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
	
	//Time Complexity : O(n), where n is the height of tree
	//Space Complexity : O(n), for recursion stack
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : Checking of the tree is balanced first
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;

		return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
	}
	
	private int height(TreeNode root) {
		if (root == null)
			return -1;
	      
		return 1 + Math.max(height(root.left), height(root.right));
	}
}
