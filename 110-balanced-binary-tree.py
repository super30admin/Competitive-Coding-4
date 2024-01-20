
"""
110. Balanced Binary Tree
Easy
"""
from leetcode_runner import LeetCode, TestCase, Args
from typing import *

PROBLEM = """
Given a binary tree, determine if it is height-balanced.
 
Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:

Input: root = []
Output: true

 
Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104


"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Accepted
    Time Complexity: O(n^2)
    Space Complexity: O(h)
    Solution Explanation:
        For each node, we calculate the height of the left and right subtree.
        If the difference between the height of the left and right subtree is
        greater than 1, then the tree is not balanced. We do this recursively
        for each node in the tree.
    """
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def height(root):
            if root is None:
                return 0
            return max(height(root.left), height(root.right)) + 1
        def rec(root):
            if root is None:
                return True
            l = height(root.left)
            r = height(root.right)
            if abs(l  - r) <= 1 and (rec(root.left) and rec(root.right)):
                return True
            return False
        return rec(root)

LeetCode(PROBLEM, Solution).check()
