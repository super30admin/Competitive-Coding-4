# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n)
# Space Complexity: O(h)
class Solution:
    def dfs(self, root):
        if not root:
            return 0

        left = self.dfs(root.left)
        if left == -1:
            return -1
        left = left + 1
        right = self.dfs(root.right)
        if right == -1:
            return -1
        right = right + 1
        if abs(left - right) > 1:
            return -1
        return max(left, right)

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        return self.dfs(root) != -1

