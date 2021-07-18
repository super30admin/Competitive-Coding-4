//Time Complexity : O(n*d), d -> Depth of tree, n -> Number of nodes in the tree
// Space Complexity : O(d)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);

		return (Math.abs(leftHeight - rightHeight) <= 1) && isBalanced(root.left) && isBalanced(root.right);

	}

	int findHeight(TreeNode root) {
		if (root == null) {
			return -1;
		}

		return 1 + Math.max(findHeight(root.left), findHeight(root.right));
	}

	public static void main(String[] args) {
		BalancedBinaryTree obj = new BalancedBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		System.out.println("Is the given tree balanced? " + (obj.isBalanced(root) ? "Yes" : "No"));
	}

}
