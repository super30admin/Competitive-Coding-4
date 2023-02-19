// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


/**
 * This is more like a dfs problem where we calculate the leaf node's height and
 * then go back to parent's nodes. If at any position, left - right height > 1,
 * return -1 and false, else return 1 + max(left, right)
 *
 */
class TreeInfo {
	int height;
	boolean balanced;

	public TreeInfo(int height, boolean balanced) {
		this.height = height;
		this.balanced = balanced;
	}
}

class Solution {
	public boolean isBalanced(TreeNode root) {
		return helper(root).balanced;
	}

	public TreeInfo helper(TreeNode root) {
		if (root == null)
			return new TreeInfo(0, true);
		TreeInfo left = helper(root.left);
		if (!left.balanced)
			return new TreeInfo(-1, false);
		TreeInfo right = helper(root.right);
		if (!right.balanced)
			return new TreeInfo(-1, false);
		if (Math.abs(left.height - right.height) < 2)
			return new TreeInfo(1 + Math.max(left.height, right.height), true);
		return new TreeInfo(-1, false);
	}
}