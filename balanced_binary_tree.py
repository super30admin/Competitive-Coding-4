# Time Complexity: O(n) because we are traversing the tree once
# Space Complexity: O(h) because we are using recursion and the height of the tree is h
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only:
"""
We check if the binary tree is balanced by checking if the difference in height of the left 
and right subtrees is less than 2 and also recursiely seeing if the left and the right trees are balanced.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None: return True

        return abs(self.height(root.left) - self.height(root.right)) < 2 and self.isBalanced(root.left) and self.isBalanced(root.right)

    def height(self, node):
        if node == None: return -1

        return 1 + max(self.height(node.left), self.height(node.right))
