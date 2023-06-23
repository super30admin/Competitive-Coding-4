"""
Problem : 2

Time Complexity : O(n)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

defining a function dfs that calculates the height of a binary tree, and recursively checks the balance 
condition for each node.
"""

# Balanced Binary Tree

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
                return [True,0]
            left,right=dfs(root.left),dfs(root.right)
            balanced=(left[0] and right[0] and abs(left[1]-right[1])<=1)
            return [balanced,1+max(left[1],right[1])]

        return dfs(root)[0]