# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        
        def height(root):
            if root is None:
                return 0
            
            left=height(root.left)
            right=height(root.right)
            
            return 1+max(left,right)
        
        left=height(root.left)
        right=height(root.right)
        
        return abs(left-right)<=1 and self.isBalanced(root.left) and self.isBalanced(root.right)
        
        
            