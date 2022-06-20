# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        def helper(node):
            if node is None:
                return [0, True]
            
            left = helper(node.left)
            right = helper(node.right)
            balanced = False
            if left[1] and right [1] and abs(left[0] - right[0]) <= 1:
                balanced = True
            
            return [1 + max(left[0],right[0]), balanced]
        
        return helper(root)[1]
        
