# // Time Complexity : O(NLOGN)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        
        def height(root):
            
            if not root:
                return -1
            
            return 1 + max(height(root.left), height(root.right))
        
        def isBalanced(root):
            
            if not root:
                return True
            
            return abs(height(root.left) - height(root.right)) <= 1 and isBalanced(root.left) and isBalanced(root.right)
        
        return isBalanced(root)
        