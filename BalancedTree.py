# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : Postorder traversal - Check height of both left and right subtree and compare.

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.balanced = True
        self.helper(root)
        return self.balanced

    def helper(self, node):
        if not node or not self.balanced:
            return 0

        leftH = self.helper(node.left)
        rightH = self.helper(node.right)

        if abs(leftH-rightH) > 1:
            self.balanced = False
            return 0
        
        return 1 + max(leftH, rightH)
        