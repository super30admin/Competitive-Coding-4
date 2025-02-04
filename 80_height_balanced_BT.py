# Time complexity - O(n)
# Space complexity - O(h)

# Approach - Have another function that computes height of the subtree, compare height of subtree.left
# to subtree.right, return False if diff > 1, finally if False condition not found, return True.

from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        if abs(self.height(root.left) - self.height(root.right)) > 1:
            return False
        return self.isBalanced(root.left) and self.isBalanced(root.right)
    
    def height(self, root: TreeNode) -> int:
        if not root:
            return -1
        return 1 + max(self.height(root.left), self.height(root.right))