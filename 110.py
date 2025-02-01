# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity : O(n)
# Space compexity : O(h)
from typing import Optional


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
 
            def height(root):
                if root == None:
                    return  0 
                left = height(root.left)
                if left == -1:
                    return -1
                right = height(root.right)
                if right == -1:
                    return -1
                if  abs(left - right) > 1:
                    return -1
                return max(left, right) + 1 
            return height(root) != -1