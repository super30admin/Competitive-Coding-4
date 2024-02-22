'''
TC: O(n)
SC: O(n)
'''
# Definition for a binary tree node.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.flag = True

        def dfs(root, level):
            if not root:
                return 0
            left = dfs(root.left,level)
            right = dfs(root.right, level)
            if abs(left-right)>1:
                self.flag = False
            return max(left+1, right+1)
            
        dfs(root, 0)
        return self.flag