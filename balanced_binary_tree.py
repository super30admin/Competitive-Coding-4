"""
Problem: 110. Balanced Binary Tree
Leetcode: https://leetcode.com/problems/balanced-binary-tree/
Solution: Bottom Up Recursion
Time Complexity: O(n), For every subtree, we compute its height in constant time as well as compare the height of its children.
Space Complexity: O(n), The recursion stack may go up to O(n) if the tree is unbalanced.
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        # base case - An empty tree is balanced
        if not root:
            return True

        # if not balanced, -1 or the height
        return self.height(root) != -1

    # if not balanced, return -1
    def height(self, node: TreeNode) -> int:
        # leaf node
        if not node:
            return 0

        left_height = self.height(node.left)
        right_height = self.height(node.right)

        # check if the subtrees are balanced
        if left_height == -1 or right_height == -1 or abs(left_height - right_height) > 1:
            return -1

        # return the height
        return 1 + max(left_height, right_height)

