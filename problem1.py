# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

TC:O(n)
SC:O(h)

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True

        if self.helper(root) != -1:
            return True

        return False

    def helper(self, root):
        if root is None:
            return 0

        # logic
        distA = self.helper(root.left)
        distB = self.helper(root.right)

        if distA != -1 and distB != -1 and abs(distA - distB) <= 1:
            return 1 + max(distA, distB)
        else:
            return -1

