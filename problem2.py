"""
Time Complexity : O(N)
Space Complexity :O(N)
Did this code successfully run on Leetcode :
Any problem you faced while coding this :


Your code here along with comments explaining your approach
Height balanced binary tree problem

https://leetcode.com/problems/balanced-binary-tree/
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def heightOfTree(self, root):
        if root is None:
            return -1

        return max(self.heightOfTree(root.left), self.heightOfTree(root.right)) + 1
        
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root: return True
        
        if abs(self.heightOfTree(root.left) - self.heightOfTree(root.right)) > 1:
            return False
        
        return self.isBalanced(root.left) and self.isBalanced(root.right)
