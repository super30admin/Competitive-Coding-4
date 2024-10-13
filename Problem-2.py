'''
    Time Complexity: O(n)
    Space Complexity: O(height)
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.dontCheck = False

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        heightDiff = self.checkHeight(root) 

        if heightDiff == float('inf'):
            return False
        else:
            return True
        
    def checkHeight(self, root):
        # base case
        if not root:
            return 0

        # logic
        if not self.dontCheck:
            left = self.checkHeight(root.left)
            right = self.checkHeight(root.right)
        else:
            return float('inf')

        if abs(left - right) > 1:
            self.dontCheck = True
            return float('inf')

        return 1 + max(left, right)