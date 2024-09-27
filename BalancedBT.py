# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    result = True

    def balancedBinary(self, root):

        if not root or self.result == False:
            return 0

        hl = self.balancedBinary(root.left)
        hr = self.balancedBinary(root.right)

        if abs(hl - hr) > 1:
            self.result = False

        return 1 + max(hl, hr)

    def isBalanced(self, root):

        self.balancedBinary(root)
        return self.result
