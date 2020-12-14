package mock4;

public class BalancedTree {

	// Definition for a binary tree node.
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

	private int calculateHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}

		return 1 + Math.max(calculateHeight(root.left), calculateHeight(root.right));
	}

	public boolean isBalancedTree(TreeNode root) {
		if (root == null) {
			return true;
		}

		return Math.abs(calculateHeight(root.left) - calculateHeight(root.right)) < 2 && isBalancedTree(root.left)
				&& isBalancedTree(root.right);
	}

}
