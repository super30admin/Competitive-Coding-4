# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        # Time Complexity: O(N)
        # Time Complexity: O(1)

        self.isTrue = True
        if not root: return self.isTrue

        def helper(root, depth):
            if not root: return depth
            left = (helper(root.left, depth + 1))
            right = (helper(root.right, depth + 1))
            if abs(left - right) > 1:
                self.isTrue = False
            return max(left, right)

        left = helper(root.left, 1)
        if not self.isTrue: return self.isTrue
        right = helper(root.right, 1)
        if abs(left - right) > 1: self.isTrue = False
        return self.isTrue


