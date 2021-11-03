# Time Complexity : O(nlogn) 
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findHeight(self,root):
        if root is None:
            return 0
        return 1+max(self.findHeight(root.left),self.findHeight(root.right))
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        return abs(self.findHeight(root.left) - self.findHeight(root.right)) < 2 and self.isBalanced(root.left) and self.isBalanced(root.right)
