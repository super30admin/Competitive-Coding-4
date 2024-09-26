# Balanced Binary Tree

# Time Complexity : O(n logn)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes, with Runtime: 68 ms and Memory Usage: 17.9 MB
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# Approach
"""
Using Recursion,Checking for left and right subtree to be balanced and than comparing 
heights and calculating the difference between heights of left and right subtree which 
should be not more than 1. 

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:   
    def height(self, root: TreeNode) -> int: 
        if not root: 
            return -1
        return 1 + max(self.height(root.left), self.height(root.right))
    
    def isBalanced(self, root: TreeNode) -> bool:
        if not root:
            return True
        return abs(self.height(root.left) - self.height(root.right)) < 2 \
            and self.isBalanced(root.left) \
            and self.isBalanced(root.right)
