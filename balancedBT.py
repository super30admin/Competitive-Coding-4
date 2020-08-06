# Leetcode 110. Balanced Binary Tree

# Time Complexity :  O(n) where n is the number of nodes

# Space Complexity : O(n) where n is the number of nodes

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: At every level calculate the height of left and right sub tree. If the difference between
# their heights is less than or equal to 1. If they are not balanced or their difference in height is
# greater than 1, then they are imbalanced.

# Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root == None:
            return True
        # Check left and right subtree are balanced and difference in their height is <= 1
        left_height = self.height(root.left)
        right_height = self.height(root.right)
        
        if abs(left_height-right_height) <= 1 and self.isBalanced(root.left) and self.isBalanced(root.right) :
            return True
        else:
            return False
                
    
    def height(self,root):
        if root == None:
            return 0
        else:
            return 1 + max(self.height(root.left),self.height(root.right)) 
              