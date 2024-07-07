"""
Height Balanced Binary Tree
https://youtu.be/u_a3E8bEdKE

https://leetcode.com/problems/balanced-binary-tree/description/

Time Complexity : O(n)
Space Complexity : O(n) recursive stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Trick is to find the height of left child & right child compare the difference & if it's valid then check if left sub tree & right
sub tree are balanced by calling it recursively.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution: 
    def isBalanced(self, root: Optional[TreeNode]) -> bool: # O(n)
        if root is None:
            return True

        return self.height(root) != -1
    

    def height(self, root):
        if root is None:
            return 0
        
        left_child_height = self.height(root.left)
        right_child_height = self.height(root.right)

        if abs(left_child_height - right_child_height) > 1:
            return -1
        elif left_child_height == -1 or right_child_height == -1:
            return -1
        
        return max(left_child_height, right_child_height) + 1
        


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

        left_child_height = self.height(root.left)
        right_child_height = self.height(root.right)

        if abs(left_child_height - right_child_height) > 1:
            return False

        return self.isBalanced(root.left) and self.isBalanced(root.right)
    

    def height(self, root):
        if root is None:
            return 0
        
        return max(self.height(root.left), self.height(root.right)) + 1
        