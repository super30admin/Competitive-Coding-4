'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 110. Balanced Binary Tree
# Given a binary tree, determine if it is height-balanced.

# For this problem, a height-balanced binary tree is defined as:

# a binary tree in which the left and right subtrees of every node differ in 
# height by no more than 1.


#-----------------
# Time Complexity: 
#-----------------
# O(N): Worst-case, need to traverse entire tree once.

#------------------
# Space Complexity: 
#------------------
# O(H): Max size of function call stack = H

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        self.balanced = True
        self.isBalancedHelper(root)
        return self.balanced
        
    def isBalancedHelper(self, node:TreeNode) -> int:
        if node is None:
            return 0
        
        else:
            if self.balanced is True:
                dfs_left = self.isBalancedHelper(node.left)            
                dfs_right =  self.isBalancedHelper(node.right)

                if (abs(dfs_left - dfs_right) > 1):
                    self.balanced = False

                return (max(dfs_left, dfs_right) + 1)
            else:
                return -1
        