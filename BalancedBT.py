"""
Given a binary tree, determine if it is height-balanced.
"""

# Time Complexity : O(n)
# Space Complexity : O(1) (Recursion may take O(n) under the hood)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:

    # checking if tree is balanced using recursion
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        # base case
        if root is None:
            return True

        # logic
        if (abs(self.height(root.left) - self.height(root.right))) <= 1 and self.isBalanced(root.left) is True and self.isBalanced(root.right) is True:
            return True

        return False
        
    # calculated height of the tree using recursion
    def height(self, root):

        # base case
        if root is None:
            return True
        
        # logic to calculate the height
        else:
            return max(self.height(root.left), self.height(root.right)) + 1