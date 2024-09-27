//Time complexity is O(N) as each node is being traversed
//space complexity is O(1) as we are not using any extra data structure
//This solution is submitted on leetcode

public class BigN57BalancedHeightOtherSolution {
	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */
	class Solution {
		public boolean isBalanced(TreeNode root) {
			if (root == null) {
				return true;
			}
			return check(root) != -1;
		}
		private int check(TreeNode root) {
			if (root == null)
				return 0;
			int left = check(root.left);
			if (left == -1)
				return -1;
			int right = check(root.right);
			if (right == -1)
				return -1;
			if (Math.abs(left - right) > 1)
				return -1;
			return Math.max(left, right) + 1;
		}
	}
}