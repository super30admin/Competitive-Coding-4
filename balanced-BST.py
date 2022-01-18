# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional


class Solution:

    def height(self, root):
        if root == None:
            return True

        left = self.height(root.left)
        right = self.height(root.right)

        #print(left, right)

        if abs(right-left) > 1:
            return False
        if left == False or right == False:
            return False

        return max(right, left)+1

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True

        if self.height(root) == False:
            return False

        else:
            return True
