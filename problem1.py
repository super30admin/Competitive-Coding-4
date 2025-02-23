# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        def dfs(root):
            if not root:
                return 0
            
            left_height = dfs(root.left)
            if left_height == -1:
                return -1
            
            right_height = dfs(root.right)
            if right_height == -1:
                return -1

            if abs(left_height - right_height) > 1:
                return -1

            return (max(left_height, right_height) + 1)

        tree_height = dfs(root)
        return True if tree_height != -1 else False