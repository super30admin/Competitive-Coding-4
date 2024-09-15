// Time Complexity : O(N)
// Space Complexity : O(H), H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Balanced_Tree {
	boolean flag = true;

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		helper(root);
		return flag;
	}

	private int helper(TreeNode root) {
		// base
		if (root == null) {
			return 0;
		}
		// logic
		int left = helper(root.left);
		int right = helper(root.right);
		if (Math.abs(left - right) > 1) {
			flag = false;
		}
		return Math.max(left, right) + 1;
	}
}