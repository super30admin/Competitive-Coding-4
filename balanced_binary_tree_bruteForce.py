"""
Time Complexity : nlog(n) where n is the number of tree nodes. log n is the Time complexity of balanced binary tree traversal and we are making n calls to the height function hence nlog(n)
Space Complexity :O(h) where h is the height of the tree, at a particular time recursive stack will have maximum h elements
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
As per the defination the tree is a balanced binary tree if the difference between height of left and right subtree is less than or equal to 1.
It means if every subtree of the tree is balanced binary tree then tree will be Balanced Binary tree automatically.
Hence we will check if every node in the tree has a balanced binary tree or not.
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
        
        return (max(left, right)) + 1
    
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        
        if abs(self.height(root.left) - self.height(root.right)) > 1:
            return False
        return self.isBalanced(root.left) and self.isBalanced(root.right)