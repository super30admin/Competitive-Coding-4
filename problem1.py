# https://leetcode.com/problems/balanced-binary-tree/

# Time Complexity : O(N) where N is number of elements in the binary tree.
# Space Complexity : O(H) where H is height of the tree, it is recursive stack space.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach

# Approach : Use recursion to find height at each node, and find the difference of heights between
# left subtree and right subtree. If it is greater than or equal to 2 then we update the result variable. and return it.

from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    result = True

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.height(root)
        return self.result

    def height(self, root):
        if root is None or not self.result:
            return 0
        left = self.height(root.left)
        right = self.height(root.right)

        if abs(left - right) >= 2:
            self.result = False

        return 1 + max(left, right)
