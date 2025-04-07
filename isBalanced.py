# This solution checks whether a binary tree is height-balanced using a bottom-up recursive approach.
# It recursively computes the height of each subtree while checking the balance condition (difference ≤ 1).
# If any subtree is unbalanced, it short-circuits by returning -1 to avoid unnecessary computation.

# Time Complexity: O(n), where n is the number of nodes in the tree. Each node is visited once.
# Space Complexity: O(h), where h is the height of the tree due to the recursion stack (O(log n) for balanced trees, O(n) for skewed trees).

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def helper(root):
            if not root:
                return 0
            left = helper(root.left)
            if left == -1:
                return -1
            right = helper(root.right)
            if right == -1:
                return -1
            if abs(left - right) > 1:
                return -1
            return 1 + max(left, right)

        result = helper(root)
        return False if result == -1 else True
