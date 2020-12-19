# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


# Time: O(N)

# Space: O(h) where h is the height of the tree

'''
Bottom-Up approach.

We first determine the results for leaf nodes, then to their parents and then to the ultimate root node.
'''
class Solution:
    def isBalanced(self, root):

        def isBalancedHelper(root):
            if not root: return True, -1

            left, left_h = isBalancedHelper(root.left)
            if not left: return False, 0

            right, right_h = isBalancedHelper(root.right)
            if not right: return False, 0

            return abs(left_h - right_h) <= 1, 1 + max(left_h, right_h)

        return isBalancedHelper(root)[0]





