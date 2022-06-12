#Time Complexity : O(N)
#Space Complexity : O(N)
#Did this code successfully run on Leetcode : YES
#Any problem you faced while coding this : NO

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
        return abs(self.recursive(root.left) - self.recursive(root.right)) < 2  and                 self.isBalanced(root.left) and self.isBalanced(root.right)
        
    
    def recursive(self,root):
        #base
        if not root:
            return -1
        #logic
        return 1 + max(self.recursive(root.left),self.recursive(root.right))