# Problem 2 :  Balanced Binary Tree
# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import Optional
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def calculateHeight(node: Optional[TreeNode]) -> int:
            # base case when node is None
            if node is None:
                return 0 
            # recursively calculate height of left and right sub tree
            leftHeight = calculateHeight(node.left)
            rightHeight = calculateHeight(node.right)

            # if the left or right subtree is unbalanced or the difference bewteen heights of left and right subtree means tree is unbalanced
            # assume height of balanced binary tree is -1 
            if leftHeight == -1 or rightHeight == -1 or abs(leftHeight - rightHeight) > 1:
                return -1
            # return height of the node
            return max(leftHeight, rightHeight) + 1
        # if the calculateHeight of the root is 1 or 0 then it is balanced binary tree
        return calculateHeight(root) >= 0

        