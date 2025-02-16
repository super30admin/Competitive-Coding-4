# Time Complexity : O(nlogn) - n is number of modes in tree and
#                              logn is the complexity for calculating height
# Space Complexity : O(n) - n is number of nodes in tree, for recursion stack
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
If |height(left tree) - height(right tree)| > 1; not a balanced tree, if <= 1 , balanced tree
check for root.left and root.left
"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: bool
        """

        self.isBalanced = True
        self.helper(root)
        return self.isBalanced

    def helper(self, root):
        if root is None:
            return

        left_height = self.height(root.left)
        right_height = self.height(root.right)

        if abs(left_height - right_height) > 1:
            self.isBalanced = False

        if self.isBalanced:
            self.helper(root.left)
        if self.isBalanced:
            self.helper(root.right)

    def height(self, root):
        if root is None:
            return -1

        return 1 + max(self.height(root.left), self.height(root.right))



