# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : Having had time thinking of iterative solution



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isBalanced(self, root):

        # Recursive
        def helper(root):
            if not root:
                return 0
            left = helper(root.left)
            right = helper(root.right)

            if abs(left - right) > 1 or left == -1 or right == -1:
                return -1
            return 1 + max(left, right)

        if not root:
            return True

        return helper(root) != -1
