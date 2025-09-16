# Time Complexity : O(n)
# Space Complexity : O(n) recursive stack trace
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Intuition is simple, just get the height of left and right subtree which would be 1 + max(left, right) and then at any given
# node if the value exceeds more than 1 return false.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.result = True
        self.helper(root)
        return self.result

    def helper(self, root):
        if not root:
            return 0
        left = self.helper(root.left)
        right = self.helper(root.right)
        # Logic to set the flag as false
        if (abs(left - right) > 1):
            self.result = False

        return 1 + max(left, right)