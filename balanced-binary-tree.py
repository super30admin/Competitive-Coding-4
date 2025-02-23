# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time O(n)
# Space O(h)
class Solution:
    flag = True

    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        self.dfs(root)
        return self.flag
    
    def dfs(self, root: Optional[TreeNode]) -> int:
        if root == None: return 0

        leftD = self.dfs(root.left)
        rightD = self.dfs(root.right)
        if abs(leftD-rightD) > 1: self.flag = False
        return 1+max(leftD, rightD)