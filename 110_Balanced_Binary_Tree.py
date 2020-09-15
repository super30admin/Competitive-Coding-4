# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Leetcode problem link : https://leetcode.com/problems/balanced-binary-tree/
# Time Complexity : O(n)
#  Space Complexity : O(1) 
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
    
        Top-down approach => The intuition behind this approach is calculating height at each node recursively for left and right subtree and check at each node if its balanced or not
       This can be optimized by storing the height of each node in a hashmap
     '''
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if not root or (root.left == None and root.right == None):
            return True
        
        left_height = self.__height(root.left)
        right_height = self.__height(root.right)
        
        if abs(left_height - right_height) > 1:
            return False
        
        return self.isBalanced(root.left) and self.isBalanced(root.right)
    
    def __height(self,root):
        if root == None:
            return 0
        
        left_height = self.__height(root.left)
        right_height = self.__height(root.right)
        
        return max(left_height,right_height) + 1
        