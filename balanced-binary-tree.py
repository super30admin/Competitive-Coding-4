'''
Given a binary tree, determine if it is height-balanced.
'''

# // Time Complexity : O(n)
# // Space Complexity : O(1)
# # // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        def check_balance(node):
            # base case
            if not node: return 0
                # height = 0
                # balanced = True
            # traversal

            left_tree = check_balance(node.left)
            if left_tree == -1:
                return -1

            right_tree = check_balance(node.right)
            if right_tree == -1:
                return -1

            if abs(left_tree-right_tree) > 1:
                return -1
            
            return max(left_tree, right_tree) + 1

        return check_balance(root) != -1
