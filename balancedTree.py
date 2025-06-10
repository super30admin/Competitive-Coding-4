"""
Problem: Balanced binary tree
approach: get the left and right heights and if the absolute difference > 1 then it's not valid and return False else return True. Use postOrder traversal.
t.c.=> O(n)
s.c. => O(h) where h is the height of tree
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self, root):
        if not root:
            return [0, True]
        
        lHt, isLBalanced = self.helper(root.left)
        if not isLBalanced:
            return [-1, isLBalanced]

        rHt, isRBalanced = self.helper(root.right)

        if not isRBalanced:
            return [-1, isRBalanced]

        diff = abs(lHt - rHt)
        maxHt = 1 + max(lHt, rHt)
        if diff > 1:
            return [maxHt, False]
        return [maxHt, True]

        
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        _, isTreeBalanced = self.helper(root)
        return isTreeBalanced