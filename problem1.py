# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
Time Complexity: O(n) where n are the number of nodes

Space Complexity: O(H) where H is the height of the tree (varies from logn to n)

"""
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        def dfs(node): 
            if not node or not self.flag: 
                return 0

            ld = dfs(node.left)
            rd = dfs(node.right)

            if abs(ld-rd) > 1: 
                self.flag = False

            return 1 + max(ld, rd)

        dfs(root)
        return self.flag


