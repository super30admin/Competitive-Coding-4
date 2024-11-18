# Approach:
# 1. We will use a recursive approach to check the balance of each subtree. A tree is balanced if for every node, 
#    the height difference between the left and right subtree is no more than 1.
# 2. We calculate the height of each subtree while simultaneously checking for balance. If at any point a subtree 
#    is unbalanced, we return False immediately.
# 3. If all subtrees are balanced, we return True indicating the tree is balanced.

# Time Complexity : O(n), where n is the number of nodes in the binary tree. Each node is visited once.
# Space Complexity : O(h), where h is the height of the tree. In the worst case, the recursion stack takes O(h) space.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        # Helper function to calculate the height of the tree and check if it's balanced
        def check_balance(node: Optional[TreeNode]) -> int:
            # Base case: if the node is None, the height is 0
            if not node:
                return 0
            
            # Recursively check the left subtree
            left_height = check_balance(node.left)
            if left_height == -1:  # If left subtree is unbalanced, return -1
                return -1
            
            # Recursively check the right subtree
            right_height = check_balance(node.right)
            if right_height == -1:  # If right subtree is unbalanced, return -1
                return -1
            
            # If the current node is unbalanced, return -1
            if abs(left_height - right_height) > 1:
                return -1
            
            # Return the height of the current node
            return 1 + max(left_height, right_height)
        
        # Check if the tree is balanced starting from the root
        return check_balance(root) != -1
