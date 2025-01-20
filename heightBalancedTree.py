# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        def dfs(root):  # -> T/F, h
            # Base Case
            if not root:
                return [True, 0]
            # Recursive Case
            l, r = dfs(root.left), dfs(root.right)
            isBal = l[0] and r[0] and (abs(l[1] - r[1]) <= 1)
            return [isBal, 1 + max(l[1], r[1])]
        return dfs(root)[0]
        # T: O(n), S: O(h)