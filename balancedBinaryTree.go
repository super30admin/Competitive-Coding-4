/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

package main

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}
	leftHeight := maxHeight(root.Left)
	rightHeight := maxHeight(root.Right)
	if leftHeight > rightHeight {
		if leftHeight-rightHeight > 1 {
			return false
		}
	} else {
		if rightHeight-leftHeight > 1 {
			return false
		}
	}
	return isBalanced(root.Left) && isBalanced(root.Right)
}

func maxHeight(root *TreeNode) int {
	if root == nil {
		return 0
	}
	left := maxHeight(root.Left)
	right := maxHeight(root.Right)
	if left > right {
		return left + 1
	} else {
		return right + 1
	}
}
