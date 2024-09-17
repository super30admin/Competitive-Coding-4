# Time complexity : O(n), number of nodes
# Space complexity : O(H), height of the tree
# The code ran on Leetcode

# Maintain height at each node. If the difference between the children at any point is greater than 1, return False

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        self.flag = True
        def helper(root):
            if not root:
                return 0
            
            left = helper(root.left)
            right = helper(root.right)

            if abs(right - left) > 1:
                self.flag = False
            return 1 + max(left, right)

        helper(root)
        return self.flag