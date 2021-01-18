/*
 * The complexity of the algorithm is O(n log n) where n is no of elements.
 * 
 */

public class BalancedBinaryTree {

	public class TreeNode {
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

	private boolean result = true;

	public boolean isBalanced(TreeNode root) {

		if (root == null)
			return true;

		helper(root);

		return result;
	}

	private int helper(TreeNode root) {
		// base
		if (root == null)
			return 0;

		int left = helper(root.left);
		int right = helper(root.right);

		// logic

		if (Math.abs(left - right) > 1) {

			result = false;
		}

		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BalancedBinaryTree objIn = new BalancedBinaryTree();

	}

}
