"""
TC=O(N)
SC=O(N) -->recursive stack

"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root is None:
            return True
        
        left=self.findheight(root.left)
        right=self.findheight(root.right)
       
        return (abs(left-right)<=1) and self.isBalanced(root.left) and self.isBalanced(root.right)
        
    def findheight(self,root):
        if root is None:
            return 0
        return 1+max(self.findheight(root.left),self.findheight(root.right))