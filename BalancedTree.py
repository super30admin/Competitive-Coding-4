# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# // Time Complexity : O(N)
# // Space Complexity : O(N)
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        return self.helper(root)[1]

    def helper(self, root):
        if not root:
            return (0, True)
        countLeft, lValid = self.helper(root.left)
        countRight, rValid = self.helper(root.right)
        if lValid and rValid:
            if abs(countLeft - countRight) >= 2:
                return (-1, False)
            else:
                return (1 + max(countLeft, countRight), True)
        else:
            return (-1, False)
