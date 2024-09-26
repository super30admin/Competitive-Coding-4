# 110. Balanced Binary Tree
# https://leetcode.com/problems/balanced-binary-tree/

# Time Complexiety: O(n)
# Space Complexiety: O(n) [recurssion stack]

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def _helper(self, root):
        if root:
            if root.left == None and root.right == None:
                return 0

            leftChild = self._helper(root.left) if root.left else -1
            rightChild = self._helper(root.right) if root.right else -1
            
            if abs(leftChild-rightChild) > 1:
                return -100000
            
            return max(leftChild, rightChild) + 1
                
    
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        
        result = self._helper(root)
        
        if result < 0:
            return False
        else:
            return True