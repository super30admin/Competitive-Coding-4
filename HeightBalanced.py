# Time Complexity: O(n)
# Space Complexity: O(h) where h is the height of the tree O(n) in the case of a skewed tree
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import Optional


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.heightOfTree(root) != -1

    def heightOfTree(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        leftHeight = self.heightOfTree(root.left)
        if leftHeight == -1: 
            return -1
        rightHeight = self.heightOfTree(root.right)
        if rightHeight == -1: 
            return -1
        if abs(leftHeight - rightHeight) > 1:
            return -1
        return 1+max(leftHeight, rightHeight)

        