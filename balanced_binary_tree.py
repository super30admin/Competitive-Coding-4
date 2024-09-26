"""
Time Complexity : O(n) where n is the number of tree nodes. 
Space Complexity :O(h) where h is the height of the tree, at a particular time recursive stack will have maximum h elements
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
As per the defination the tree is a balanced binary tree if the difference between height of left and right subtree is less than or equal to 1.
In this approach, instead of checking height of every node we will calculate height only if the child subtree is balanced binary tree. If any of the subtree is invalid balanced binary tree then return its height as -1.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def height(self, root):
        #base
        if root == None:
            return 0
        
        #Logic
        left = self.height(root.left)
        right = self.height(root.right)
        
        if left == -1 or right == -1:
            return -1
        if abs(left-right) > 1:
            return -1
        return (max(left, right)) + 1
    
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        return self.height(root) != -1