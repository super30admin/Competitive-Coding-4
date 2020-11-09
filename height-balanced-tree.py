# Time Complexity: O(n)
# Space Compexity: O(height)
# Approach: Solved using Bottom Up DFS
# Every node returns it's height
# On returning, a node computes it's left and right height sub-trees and finds the difference
# If the abs diff is > 1, set the result to false.
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        bal = [True]
        if not root:
            return True

        def dfs(node):
            lh, rh, h = 0, 0, 0
            # Compute the left and right heights
            if node.left:
                lh = 1 + dfs(node.left)
                h = lh
            if node.right:
                rh = 1 + dfs(node.right)
                h = max(h, rh)
                # If the difference in heights is > 1, set the result to False
            if abs(lh-rh) > 1:
                bal[0] = False
            return h

        dfs(root)
        return bal[0]
