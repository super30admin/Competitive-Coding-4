"""
Name: Srinidhi 
Did it run on LC: yes
Time Complexity: O(n)
Space Complexity: O(n)

Logic: Height is defined as the max of the left side of a node and the right
side of the node.

For every node, recursiveley find out if the height differs more than 1
at any point if it happens, then return 1
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
        
        def height(node):
            if node is None:
                return 0
            
            return max(height(node.left),height(node.right)) + 1
            
            
        return self.isBalanced(root.left) \
               and self.isBalanced(root.right) \
               and abs(height(root.left) -(height(root.right))) < 2