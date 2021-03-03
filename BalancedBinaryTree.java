
public class BalancedBinaryTree {

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

	public boolean isBalanced(TreeNode root) {

		if (root == null)
			return true;

		// to be balaced tree each sub tree should be balances
		// need to check height of left and right sub tree to defined it balanced
		return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;

	}

	private int height(TreeNode root) {

		// if root is null return 0
		if (root == null)
			return 0;

		// else add 1 to calculate the curr level
		return 1 + Math.max(height(root.left), height(root.right));
	}

}
