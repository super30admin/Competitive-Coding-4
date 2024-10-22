# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        return self.dfs(root) >= 0
    def dfs(self, root: TreeNode) -> bool:
        if root is None: return 0
        leftH = self.dfs(root.left)
        rightH = self.dfs(root.right)
        if leftH < 0 or rightH < 0 or abs(leftH - rightH) > 1: return -1
        return max(leftH, rightH) + 1
