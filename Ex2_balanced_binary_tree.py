# Time Complexity: O(N), where N is the number of nodes in the tree. Each node is visited once.
# Space Complexity: O(H), where H is the height of the tree (due to recursion stack).
# Did this code successfully run on Leetcode: YES
# Any problem you faced while coding this: No

from typing import Optional

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:

        # Bottom-Up Approach (Optimized)

        def check(node):
            if not node:
                return 0  # Height of an empty subtree is 0

            left = check(node.left)
            if left == -1:
                return -1  # Left subtree is not balanced

            right = check(node.right)
            if right == -1:
                return -1  # Right subtree is not balanced

            if abs(left - right) > 1:
                return -1  # Current node is not balanced

            return 1 + max(left, right)  # Return height of the current subtree

        return check(root) != -1

# --------------------------------------------------------------------------------------------------------

        # Top-Down Approach (Naive)
        # Time Complexity: O(N^2) in the worst case (due to repeated height calculations)
        # Space Complexity: O(H), where H is the height of the tree (recursion stack)
        
        # if root is None:
        #     return True
        
        # def height(node):
        #     if node is None:
        #         return 0
        #     return 1 + max(height(node.left), height(node.right))
        
        # left_height = height(root.left)
        # right_height = height(root.right)

        # if abs(left_height - right_height) > 1:
        #     return False
        
        # return self.isBalanced(root.left) and self.isBalanced(root.right)
