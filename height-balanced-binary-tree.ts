/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */
// Time complexity - O(n), n = number of nodes
// Space complexity - O(h), height of the Tree
function isBalanced(root: TreeNode | null): boolean {
	let flag = true;
	if (root === null) return true;
	helper(root);
	return flag;

	function helper(root: TreeNode) {
		if (root === null) return -1;
		const left = helper(root.left);
		const right = helper(root.right);
		const hDiff = Math.abs(left - right);
		if (hDiff > 1) {
			flag = false;
		}

		return 1 + Math.max(left, right);
	}
}
