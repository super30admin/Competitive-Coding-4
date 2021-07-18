//Time Complexity : O(d), d -> Depth of tree, O(n) worst case, n -> Number of nodes in the tree
// Space Complexity : O(d), Worst Case O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class DiameterOfBinaryTree {
	int diameter;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		diameter = 0;
		// Function
		height(root);
		return diameter;
	}

	public int height(TreeNode root) {
		if (root == null) {
			return -1;
		}

		int leftHeight = 1 + height(root.left);
		int rightHeight = 1 + height(root.right);
		diameter = Math.max(diameter, leftHeight + rightHeight);
		return Math.max(leftHeight, rightHeight);
	}

	public static void main(String[] args) {
		DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		System.out.println("Diameter of given binary tree: " + obj.diameterOfBinaryTree(root));
	}

}
