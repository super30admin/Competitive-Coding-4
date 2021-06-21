// Time Complexity : O(N)
// Space Complexity : O(H) // H is height of the tree. which is stack size as well 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Do pre order traversal.
 * 2. For each node calculate left and right subtree height and check is it balanced or not.
 * 3. It is bottom up botton node value should be an input to up level node.
 * 3. After each iteration check and update boolean value.
 */

class BalancedbinaryTree {
	boolean isbal = true;

	public boolean isBalanced(TreeNode root) {

		helper(root);
		return isbal;

	}

	public int helper(TreeNode root) {
		if (!isbal || root == null)
			return 0;

		int lefth = helper(root.left);
		lefth++;

		int righth = helper(root.right);
		righth++;

		if (Math.abs(lefth - righth) > 1) {
			isbal = false;
		}

		return (Math.max(lefth, righth));

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(new BalancedbinaryTree().isBalanced(root));
	}
}