// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
in recursive function
if root is nil return 0
left = recursive(root.Left)
if left is -1 return -1
right = recursive(root.right)
if right is -1 return -1
if abs diff between left, right >1 return -1
return max(left, right)+1
*/

package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func isBalanced(root *TreeNode) bool {
	return h(root) != -1
}

func h(root *TreeNode) int {
	if root == nil {
		return 0
	}

	l := h(root.Left)
	if l == -1 {
		return -1
	}

	r := h(root.Right)
	if r == -1 {
		return -1
	}

	if abs(l - r) > 1 {
		return -1
	}

	return max(l, r) + 1
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}


func MainBalanced() {
	root := &TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val: 3,
				Left: &TreeNode{Val: 4},
				Right: &TreeNode{Val: 4},
			},
			Right: &TreeNode{Val:3},
		},
		Right: &TreeNode{Val: 2},
	}
	fmt.Println(isBalanced(root))//expected false
}
