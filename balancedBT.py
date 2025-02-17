"""
TC- O(n)
SC - O(h)
"""


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

            # process left subtree
            leftheight = check_balance(node.left)
            if leftheight == -1:
                return -1

            # process right subtree
            rightheight = check_balance(node.right)
            if rightheight == -1:
                return -1

            if abs(leftheight - rightheight) > 1:
                return -1

            return 1 + max(leftheight, rightheight)

        return check_balance(root) != -1