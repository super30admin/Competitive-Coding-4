# https://leetcode.com/problems/balanced-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root):
        if not root:
            return True
        if self.helper(root) == -1:
            return False
        return True

    def helper(self, root):
        if not root:
            return 0
        left = self.helper(root.left)
        right = self.helper(root.right)
        if left == -1 or right == -1:
            return -1
        if abs(left - right) > 1:
            return -1
        return 1 + max(left, right)
