//Time complexity is O(N) as each node is being traversed
//space complexity is O(1) as we are not using any extra data structure
//This solution is submitted on leetcode
public class BigN57BalancedHeightTree {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {
		public boolean isBalanced(TreeNode root) {
			if (root == null) {
				return true;
			}
			return (Math.abs(height(root.left) - height(root.right)) <= 1) && isBalanced(root.left)
					&& isBalanced(root.right);
		}
		private int height(TreeNode root) {
			// base
			if (root == null)
				return 0;
			int left = height(root.left);
			int right = height(root.right);
			return Math.max(left, right) + 1;
		}
	}
}