package competitiveCoding4;


//Time COmplexity: O(n^2) because nodes of trees are traversed twice.
// Space Complexity: O(1) because we use constant space
public class BalancedBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {

		if (root == null)
			return true;
		int hleft = height(root.left);
		int hright = height(root.right);

		if (Math.abs(hleft - hright) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}

	public int height(TreeNode root) {
		// base condition
		if (root == null)
			return 0;

		int height_left = height(root.left);
		int height_right = height(root.right);

		return Math.max(height_left, height_right) + 1;
	}

}
