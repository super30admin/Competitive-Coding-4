# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#Time:O(n)
#Space:O(n)
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        self.ans = True
        
        def helper(root):
            if not self.ans:
                return 0
            if not root:
                return 0
            
            left_height  = helper(root.left)
            right_height = helper(root.right)
            if abs(left_height-right_height)>1:
                self.ans = False
            return 1 + max(left_height, right_height)
        
        if not root:
            return True
        helper(root)
        return self.ans
            
        
        
        