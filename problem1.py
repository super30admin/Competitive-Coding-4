# https://leetcode.com/problems/balanced-binary-tree/
# Time Complexity: O(n)
# Space Complexity: O(n) 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.isBalancedHelper(root)[0] 
    
    def isBalancedHelper(self, root: TreeNode) -> (bool, int):
        if not root:
            return True, 0

        left_balanced, left_height = self.isBalancedHelper(root.left)
        right_balanced, right_height = self.isBalancedHelper(root.right)
        diff = abs(left_height - right_height) <= 1  
        height = 1 + max(left_height, right_height)

        return diff and left_balanced and right_balanced, height
