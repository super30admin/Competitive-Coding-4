'''
Time Complexity: O(n)
Space Complexity: O(n)
Run on Leetcode: YES
'''
from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def getHeight(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        return max(self.getHeight(root.left), self.getHeight(root.right)) + 1
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        left = self.getHeight(root.left)
        right = self.getHeight(root.right)
        return abs(left - right) <= 1 and self.isBalanced(root.left) and self.isBalanced(root.right)