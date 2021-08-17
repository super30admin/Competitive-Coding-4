"""
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        if self.helper(root) == -1:
            return False
        else:
            return True
    # Helper function to calculate the height and check if balanced or not
    def helper(self, root):
        if not root:
            return 0
        heightLeft = self.helper(root.left)
        heightRight = self.helper(root.right)
        # If the difference or right and left subtree greater than 1 return false
        if heightLeft == -1 or heightRight == -1 or abs(heightLeft - heightRight)              > 1:
            return -1
        return 1 + max(heightLeft, heightRight)